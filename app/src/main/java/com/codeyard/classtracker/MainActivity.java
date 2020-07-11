package com.codeyard.classtracker;

import android.bluetooth.BluetoothGattDescriptor;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.codeyard.classtracker.models.LectureModel;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    final String TAG = MainActivity.class.getName();
    private MaterialCardView card1;

//    private void init() {
//        card1 = findViewById(R.id.card1);
//    }
FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
frameLayout = findViewById(R.id.frameLayout);
//        init();

//        card1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                card1.toggle();
//            }
//        });
//
//TODO add a different layout (fragment) for the card views
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//Chnge the layout toi the fragment
                Fragment addClassFragment = new AddLectureFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,addClassFragment)
                        .commit();


            }
        });

        SugarContext.init(MainActivity.this);
        SchemaGenerator schemaGenerator = new SchemaGenerator(this);
        schemaGenerator.createDatabase(new SugarDb(this).getDB());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        Log.d(TAG, "onResume: " + getAllLectures());
        for (int i =0;i<getAllLectures().size();i++){
            Log.d(TAG, "onResume: LECTURE");
            Log.d(TAG, "onResume: NAME: "+getAllLectures().get(i).getName());
            Log.d(TAG, "onResume: DATE: "+getAllLectures().get(i).getDate().toString());

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public List<LectureModel> getAllLectures() {
        return LectureModel.listAll(LectureModel.class);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
