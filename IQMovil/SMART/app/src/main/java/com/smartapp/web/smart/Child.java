package com.smartapp.web.smart;

/**
 * Created by klcho.o on 12/9/2017.
 */

public class Child {

    private String Name;
    private String Age;
    private String Locate;
    private String School;

    public Child(String pName, String pAge, String pLocate, String pSchool) {
        this.setName(pName);
        this.setAge(pAge);
        this.setLocate(pLocate);
        this.setSchool(pSchool);
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getLocate() {
        return Locate;
    }

    public void setLocate(String locate) {
        Locate = locate;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }
}