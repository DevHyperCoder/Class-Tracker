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

    @Ignore
    int viewType;

    @Ignore
    private String heading;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    //    For sugarDb
    @SuppressWarnings("unused")
    public LectureModel() {

    }

    //    Normal Constructor
    public LectureModel(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
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
