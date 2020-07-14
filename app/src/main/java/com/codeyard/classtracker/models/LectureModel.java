package com.codeyard.classtracker.models;

import android.util.Log;

import com.orm.SugarRecord;

import java.util.Date;

public class LectureModel extends SugarRecord {
    private String name;
    private Date date;

    //    For sugarDb
    public LectureModel() {

    }
String TAG = LectureModel.class.getName();
    //    Normal Constructor
    public LectureModel(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
