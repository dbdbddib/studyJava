package com.example.myjpa.phonebook;

import com.example.myjpa.category.CategoryDto;
import com.example.myjpa.category.CategoryEntity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pb")

public class PhoneBookControllor {
    private static Logger logger = LoggerFactory.getLogger(PhoneBookControllor.class);

    @Autowired
    private IPhoneBookService<IPhoneBook> phoneBookService;



    // 매개변수에 인터페이스형을 선언하면 안되는 이유는 생성자, 객체 생성을 못 하기 때문에 JSON 형태를 못 받음
    @PostMapping
    public ResponseEntity<IPhoneBook> insertPB(@RequestBody PhoneBookRequest dto) {
        try {
            if (dto == null) {
                return ResponseEntity.badRequest().build();
            }
            IPhoneBook result = this.phoneBookService.insert(dto);
            if (result == null) {
                return ResponseEntity.badRequest().build();
            }

            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<IPhoneBook>> getAll() {
        try {
            List<IPhoneBook> result = this.phoneBookService.getAllList();
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        try {
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }
            boolean result = this.phoneBookService.remove(id);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<IPhoneBook> update(@PathVariable Long id, @RequestBody PhoneBookRequest dto) {
        try {
            if (id == null || dto == null) {
                return ResponseEntity.badRequest().build();
            }
            IPhoneBook result = this.phoneBookService.update(id, dto);
            if (result == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<IPhoneBook> findById(@PathVariable Long id) {
        try {
            if (id == null || id <= 0) {
                return ResponseEntity.badRequest().build();
            }
            IPhoneBook result = this.phoneBookService.findById(id);
            if (result == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/name:{name}")
    public ResponseEntity<List<IPhoneBook>> findAllByName(@PathVariable String name) {
        try {
            if (name == null || name.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            List<IPhoneBook> result = this.phoneBookService.getListFromName(name);
            if (result == null || result.size() <= 0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/group:{category}")
    public ResponseEntity<List<IPhoneBook>> findAllByCategory(@PathVariable Integer category) {
        try {
            if (category == null) {
                return ResponseEntity.badRequest().build();
            }
            CategoryEntity categoryEntity = CategoryEntity.builder().id(Long.parseLong(category.toString())).build();
            List<IPhoneBook> result = this.phoneBookService.getListFromCategory(categoryEntity);
            if (result == null || result.size() <= 0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/phone:{phoneNumber}")
    public ResponseEntity<List<IPhoneBook>> findAllByPhoneNumber(@PathVariable String phoneNumber) {
        try {
            if (phoneNumber == null || phoneNumber.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            List<IPhoneBook> result = this.phoneBookService.getListFromPhoneNumber(phoneNumber);
            if (result == null || result.size() <= 0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/email:{email}")
    public ResponseEntity<List<IPhoneBook>> findAllByEmail(@PathVariable String email) {
        try {
            if (email == null || email.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            List<IPhoneBook> result = this.phoneBookService.getListFromEmail(email);
            if (result == null || result.size() <= 0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }
}
