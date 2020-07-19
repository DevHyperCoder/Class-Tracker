package com.codeyard.classtracker.db;

import android.content.Context;
import android.util.Log;

import com.codeyard.classtracker.models.LectureModel;
import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DBHelper {
final static  String TAG ="DBHelper";
    /**
     * Gets all the lectures from the Database
     * @return List of Lecture Models
     */
    public static List<LectureModel> getAllLectures() {
        return LectureModel.listAll(LectureModel.class);
    }

    public static List<LectureModel> getAllLecturesAfterCurrentTime(){
        Calendar calendar = Calendar.getInstance();

        List<LectureModel> allLectures = getAllLectures();

        List<LectureModel> lecturesAfterCurrentTime = new ArrayList<>();

        for (int i =0;i<allLectures.size();i++){
            Date date = allLectures.get(i).getDate();

            Calendar lecturemodelCalender =Calendar.getInstance();
            lecturemodelCalender.setTime(date);

            if(calendar.before(lecturemodelCalender)){
                lecturesAfterCurrentTime.add(allLectures.get(i));
            }
        }

        return lecturesAfterCurrentTime;
    }

    /**
     * Initialises the Database
     * Uses SchemaGenerator to create the db and prevents any runtime errors
     * @param context Context
     */
    public static void initDb(Context context){
        SugarContext.init(context);
        SchemaGenerator schemaGenerator = new SchemaGenerator(context);
        schemaGenerator.createDatabase(new SugarDb(context).getDB());
    }
}
