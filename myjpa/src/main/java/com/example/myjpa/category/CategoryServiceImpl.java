package com.example.myjpa.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    private boolean isValidInsert(ICategory dto) {
        if (dto == null) {
            return false;
        } else if (dto.getName() == null || dto.getName().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public ICategory findById(Long id) {
        Optional<CategoryEntity> find = this.categoryJpaRepository.findById(id);
        return find.orElse(null);   // find의 값이 없으면 null로 리턴..
    }

    @Override
    public ICategory findByName(String name) {
        Optional<CategoryEntity> byName = this.categoryJpaRepository.findByName(name);
        return byName.orElse(null);
    }

    @Override
    public List<ICategory> getAllList() {
        List<ICategory> list = this.getICategoryList(this.categoryJpaRepository.findAll());
        return list;
    }

    private List<ICategory> getICategoryList(List<CategoryEntity> list) {
        if(list == null || list.size() <= 0){
            return new ArrayList<>();
        }
        List<ICategory> result = list.stream()
                .map(entity -> (ICategory)entity)
                .toList();
        return result;
    }

    @Override
    public ICategory insert(ICategory category) throws Exception {
        if (!this.isValidInsert(category)) {
            return null;
        }
        CategoryEntity entity = new CategoryEntity();
        entity.copyFields(category);
        ICategory result = this.categoryJpaRepository.saveAndFlush(entity);
        return result;
    }

    @Override
    public boolean remove(Long id) throws Exception {
        ICategory find = this.findById(id);
        if (find == null) {
            return false;
        }
        this.categoryJpaRepository.deleteById(id);
        return true;
    }

    @Override
    public ICategory update(Long id, ICategory category) throws Exception {
        ICategory find = this.findById(id);
        if (find == null) {
            return null;
        }
        CategoryEntity entity = CategoryEntity.builder()
                .id(id).name(find.getName()).build();
        entity.copyFields(category);
        return this.categoryJpaRepository.saveAndFlush(entity);
    }


    @Override
    public List<ICategory> findAllByNameContains(String name) {
        if (name == null || name.isEmpty()) {
            return new ArrayList<>();
        }
        List<CategoryEntity> list = this.categoryJpaRepository.findAllByNameContains(name);
        List<ICategory> result = new ArrayList<>();
        for(CategoryEntity item : list){
            result.add((ICategory) item);
        }
        return result;
    }
}
