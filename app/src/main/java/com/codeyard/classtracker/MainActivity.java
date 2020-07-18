package com.codeyard.classtracker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.codeyard.classtracker.db.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    final String TAG = MainActivity.class.getName();



    FrameLayout frameLayout;

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        frameLayout = findViewById(R.id.frameLayout);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment cardFragment = new CardFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, cardFragment)
                .commit();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {

            Fragment addClassFragment = new AddLectureFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, addClassFragment).addToBackStack(AddLectureFragment.class.getName())
                    .commit();


        });

        DBHelper.initDb(MainActivity.this);


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
