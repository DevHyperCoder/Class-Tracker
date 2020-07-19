package com.codeyard.classtracker.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeModel {

    private int hour;
    private int minute;
    private int second;
    private int year;
    private int monthOfYear;
    private int dayOfMonth;
    private Calendar calendar;
public Calendar getCalendar(){
    return calendar;
}
    /**
     * Constructor
     * Initialises the calender instance
     */
    public DateTimeModel() {
        calendar = Calendar.getInstance();
    }

    /**
     * @return Date object with the params given in setDate method and setTime method
     */
    public Date getDate() {
        return calendar.getTime();
    }


    /**
     * Sets time using the provided parameters
     * Sets internal Calender
     *
     * @param hour   hour
     * @param minute minute
     * @param second second
     */
    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        setCalenderWithTime();
    }

    /**
     * Sets date using the provided parameters
     * Sets internal Calender
     *
     * @param year  year
     * @param month month
     * @param day   day
     */
    public void setDate(int year, int day, int month) {
        this.year = year;
        this.monthOfYear = month;
        this.dayOfMonth = day;
        setCalenderWithDate();
    }


    /**
     * Formatting pattern: yyyy-mm-dd
     *
     * @return Internal Date variable formatted to string
     */
    public String getDateString() {
        DateFormat dateFormat = new
                SimpleDateFormat("yyyy-mm-dd"
                , Locale.getDefault());

        return dateFormat.format(getDate());
    }

    /**
     * Formatting pattern: hh:mm:ss
     *
     * @return Internal Date variable formatted to String
     */
    public String getTimeString() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss", Locale.getDefault());
        return dateFormat.format(getDate());
    }


    public void setCalenderWithDate() {
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, monthOfYear);
    }

    public void setCalenderWithTime() {
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
    }

}
