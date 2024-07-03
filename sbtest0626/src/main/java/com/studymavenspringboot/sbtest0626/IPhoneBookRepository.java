package com.studymavenspringboot.sbtest0626;

import com.studymavenspringboot.sbtest0626.make.PhoneBook;
import org.json.simple.JSONObject;

import java.util.List;

public interface IPhoneBookRepository<T> {
    boolean saveData(List<T> listData) throws Exception;

    boolean loadData(List<T> listData) throws Exception;
}
