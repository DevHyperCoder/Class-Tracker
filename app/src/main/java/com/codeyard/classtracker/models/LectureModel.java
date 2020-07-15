package com.codeyard.classtracker.models;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.Date;

/**
 * Model for Lectures to be stored in db using SugarDB
 */
public class LectureModel extends SugarRecord {
    @Ignore
    String TAG = LectureModel.class.getName();
    private String name;
    private Date date;

    //    For sugarDb
    @SuppressWarnings("unused")
    public LectureModel() {

    }

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
