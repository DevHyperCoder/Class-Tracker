package com.codeyard.classtracker.db;

import android.content.Context;

import com.codeyard.classtracker.models.LectureModel;
import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.util.List;

public class DBHelper {

    /**
     * Gets all the lectures from the Database
     * @return List of Lecture Models
     */
    public static List<LectureModel> getAllLectures() {
        return LectureModel.listAll(LectureModel.class);
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
