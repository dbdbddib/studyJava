package com.studymavenspringboot.sbtest0626.make;

import com.studymavenspringboot.sbtest0626.EPhoneGroup;
import com.studymavenspringboot.sbtest0626.IPhoneBook;
import com.studymavenspringboot.sbtest0626.IPhoneBookRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

public class PhoneBookJsonRepository implements IPhoneBookRepository<IPhoneBook> {
    private String fileName;

    public PhoneBookJsonRepository(String fileName) {
        this.fileName = fileName;
    }

    public PhoneBook getObjectFromJson(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            throw new Exception("Error : Input jsonObject is null");
        }
        PhoneBook object = new PhoneBook();
        object.setId((Long) jsonObject.get("id"));
        object.setName((String) jsonObject.get("name"));
        object.setGroup(EPhoneGroup.valueOf((String) jsonObject.get("group")));
        object.setPhoneNumber((String) jsonObject.get("phoneNumber"));
        object.setEmail((String) jsonObject.get("email"));

        return object;
    }

    public JSONObject getJsonFromObject(IPhoneBook object) throws Exception {
        if (object == null) {
            throw new Exception("Error : Input object is null");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", object.getId());
        jsonObject.put("name", object.getName());
        jsonObject.put("group", object.getGroup().toString());
        jsonObject.put("phoneNumber", object.getPhoneNumber());
        jsonObject.put("email", object.getEmail());

        return jsonObject;
    }


    @Override
    public boolean saveData(List<IPhoneBook> PhoneBooklist) throws Exception {
        if (PhoneBooklist == null || PhoneBooklist.size() <= 0) {
            return false;
        }
        JSONArray jsonArray = new JSONArray();
        for (IPhoneBook phoneBook : PhoneBooklist) {
            JSONObject jobj = getJsonFromObject(phoneBook);
            jsonArray.add(jobj);
        }
        JSONObject jroot = new JSONObject();
        jroot.put("phoneBooks", jsonArray);

        FileWriter fileWriter = new FileWriter(fileName, Charset.defaultCharset());
        fileWriter.write(jroot.toString());
        fileWriter.flush();
        fileWriter.close();
        return true;
    }

    @Override
    public boolean loadData(List<IPhoneBook> PhoneBooklist) throws Exception {
        if (PhoneBooklist == null) {
            return false;
        }
        JSONParser parser = new JSONParser();
        File file = new File(fileName);
        if (!file.exists()) {
            return false; // 파일이 없을때 실행하면 예외 없도록 처리함
        }
        FileReader reader = new FileReader(file, Charset.defaultCharset());
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        reader.close();
//        System.out.print(jsonObject);

        JSONArray jsonArray = (JSONArray) jsonObject.get("phoneBooks");
        PhoneBooklist.clear();
        for (Object obj : jsonArray) {
            JSONObject element = (JSONObject) obj;
            PhoneBooklist.add(getObjectFromJson(element));
        }
        return true;
    }
}
