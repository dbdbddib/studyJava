package com.studymavenspringboot.sbtest0626.make;

import com.studymavenspringboot.sbtest0626.EPhoneGroup;
import com.studymavenspringboot.sbtest0626.IPhoneBook;
import com.studymavenspringboot.sbtest0626.IPhoneBookRepository;
import com.studymavenspringboot.sbtest0626.IPhoneBookService;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookServiceImpl implements IPhoneBookService<IPhoneBook> {
    private List<IPhoneBook> list = new ArrayList<>();
    private final IPhoneBookRepository<IPhoneBook> phoneBookRepository;

    public PhoneBookServiceImpl(String arg1, String fileName) throws Exception {
        if ( "-j".equals(arg1) ) {
            this.phoneBookRepository = new PhoneBookJsonRepository(fileName);
        } else if ( "-t".equals(arg1) ) {
            this.phoneBookRepository = new PhoneBookTextRepository(fileName);
        } else {
            throw new Exception( "에러: 프로그램 인자가 필요합니다. 사용법: (-j/-t) (파일명");
        }
    }

    @Override
    public int size() {
        return this.list.size();
    }

    /**
     * List<IPhoneBook> list 배열객체에서 id 가 가장 큰 숫자를 찾아서 리턴한다.
     * @return get Maximum id number value
     */
    @Override
    public Long getMaxId() {
        Long nMax = 0L;
            int may = this.list.size();
            IPhoneBook lastElement = this.list.get(may - 1);
            nMax = lastElement.getId();
        return ++nMax;
    }

    @Override
    public IPhoneBook findById(Long id) {       // for문 바이너리 서치로 바꾸기

        int may = (int)(this.list.size()/2);
        List<IPhoneBook> list1 = new ArrayList<>(this.list.subList(0, may));
        List<IPhoneBook> list2 = new ArrayList<>(this.list.subList(may + 1, this.list.size()));

        if (this.list.get(may).getId() == id){
            return list.get(may);
        } else if (this.list.get(may).getId() < id) {
                for ( IPhoneBook obj : list2 ) {
                if ( id.equals(obj.getId()) ) {
                    return obj;
                }
            }
        } else {
            for ( IPhoneBook obj : list1 ) {
                if ( id.equals(obj.getId()) ) {
                    return obj;
                }
            }
        }

        return null;
    }

    @Override
    public List<IPhoneBook> getAllList() {  // list 스트림
        return this.list;
    }

    @Override
    public boolean insert(String name, EPhoneGroup group, String phoneNumber, String email) throws Exception {
        IPhoneBook phoneBook = PhoneBook.builder()
                .id(this.getMaxId())
                .name(name).group(group)
                .phoneNumber(phoneNumber).email(email).build();
        this.list.add(phoneBook);
        return true;
    }

    @Override
    public boolean insert(IPhoneBook phoneBook) throws Exception {
        this.list.add(phoneBook);
        return true;
    }

    @Override
    public boolean remove(Long id) {
        IPhoneBook find = this.findById(id);
        if ( find != null ) {
            this.list.remove(find);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Long id, IPhoneBook phoneBook) {
        int findIndex = this.findIndexById(id);
        if ( findIndex >= 0 ) {
            phoneBook.setId(id);
            this.list.set(findIndex, phoneBook);
            return true;
        }
        return false;
    }

    private int findIndexById(Long id) {
        for ( int i = 0; i < this.list.size(); i++ ) {
            if ( id.equals(this.list.get(i).getId()) ) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<IPhoneBook> getListFromName(String findName) {
        List<IPhoneBook> findArr = new ArrayList<>();
        for ( IPhoneBook phoneBook : this.list ) {
            if (phoneBook.getName().contains(findName)) {
                findArr.add(phoneBook);
            }
        }
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromGroup(EPhoneGroup phoneGroup) {
        List<IPhoneBook> findArr = new ArrayList<>();
        for ( IPhoneBook phoneBook : this.list ) {
            if (phoneGroup.equals(phoneBook.getGroup())) {
                findArr.add(phoneBook);
            }
        }
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {
        List<IPhoneBook> findArr = new ArrayList<>();
        for ( IPhoneBook phoneBook : this.list ) {
            if (phoneBook.getPhoneNumber().contains(findPhone)) {
                findArr.add(phoneBook);
            }
        }
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {
        List<IPhoneBook> findArr = new ArrayList<>();
        for ( IPhoneBook phoneBook : this.list ) {
            if (phoneBook.getEmail().contains(findEmail)) {
                findArr.add(phoneBook);
            }
        }
        return findArr;
    }

    @Override
    public boolean loadData() throws Exception {
        return this.phoneBookRepository.loadData(this.list);
    }

    @Override
    public boolean saveData() throws Exception {
        return this.phoneBookRepository.saveData(this.list);
    }
}
