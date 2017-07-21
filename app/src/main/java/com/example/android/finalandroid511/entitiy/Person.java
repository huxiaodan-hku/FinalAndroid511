package com.example.android.finalandroid511.entitiy;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by huxiaodan on 2017/7/19.
 */

public class Person {
    int id;
    String name;
    String email;
    String phoneNumber;

    public Person(int id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public Person(JSONObject object) {
        try {
            this.id = object.getInt("userId");
            this.name = object.getString("userName");
            this.email = object.getString("userEmail");
            this.phoneNumber = object.getString("userPhoneNumber");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
