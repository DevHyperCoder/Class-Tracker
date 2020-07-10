package com.codeyard.classtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AddClass extends AppCompatActivity {
    private TextView txtTime;
    private TextView txtClass;
    private Button btnSave;
    private TextView txtWarnTime;
    private TextView txtWarnLecture;
    private Spinner daySpinner;




    public void init(){
        txtTime = findViewById(R.id.txtTime);
        txtClass = findViewById(R.id.txtClass);
        btnSave = findViewById(R.id.btnSave);
        txtWarnTime = findViewById(R.id.txtWarnTime);
        txtWarnLecture = findViewById(R.id.txtWarnLecture);
        daySpinner = findViewById(R.id.daySpinner);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        init();
        List<String> categories = new ArrayList<String>();
        categories.add("Monday");
        categories.add("Tuesday");
        categories.add("Wednesday");
        categories.add("Thursday");
        categories.add("Friday");
        categories.add("Friday");
        categories.add("Saturday");
        categories.add("Sunday");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        daySpinner.setAdapter(dataAdapter);






        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validatedata()) {
                    Toast.makeText(AddClass.this,"Clicked",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validatedata(){

        if (txtTime.getText().toString().isEmpty()){
            txtWarnTime.setText("Enter Time");
            return false;
        }
        txtWarnTime.setText("");
        if (txtClass.getText().toString().isEmpty()){
            txtWarnLecture.setText("Enter Lecture");
            return false;
        }
        txtWarnLecture.setText("");
        return true;
    }

}