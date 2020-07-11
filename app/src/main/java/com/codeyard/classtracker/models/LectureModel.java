package com.codeyard.classtracker.models;

import com.orm.SugarRecord;

import java.time.LocalDateTime;

public class LectureModel extends SugarRecord {
    private String name;
    private LocalDateTime date;

    //    For sugarDb
    public LectureModel() {

    }

//    Normal Constructor
    public LectureModel(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {

        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


}
