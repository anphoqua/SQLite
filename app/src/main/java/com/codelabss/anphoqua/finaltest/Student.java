package com.codelabss.anphoqua.finaltest;

public class Student {
    public int _id;
    public String name;
    public String phone;

    public Student(int _id, String name, String phone) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
    }

    public Student(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Student() {
    }
}
