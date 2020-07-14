package com.codeyard.classtracker.db;

import android.content.Context;

import com.codeyard.classtracker.MainActivity;
import com.codeyard.classtracker.models.LectureModel;
import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.util.List;

public class DBHelper {

    public static List<LectureModel> getAllLectures() {
        return LectureModel.listAll(LectureModel.class);
    }

    public static void initDb(Context context){
        SugarContext.init(context);
        SchemaGenerator schemaGenerator = new SchemaGenerator(context);
        schemaGenerator.createDatabase(new SugarDb(context).getDB());
    }
}
