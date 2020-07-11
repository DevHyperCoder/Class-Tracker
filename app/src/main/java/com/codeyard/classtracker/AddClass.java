package com.codeyard.classtracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codeyard.classtracker.models.LectureModel;

import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;


public class AddClass extends AppCompatActivity {
    private EditText txtTime;
    private EditText txtDay;
    private EditText txtClass;
    private Button btnSave;
    private TextView txtWarnDay;
    private TextView txtWarnTime;
    private TextView txtWarnLecture;

    public void init() {
        txtTime = findViewById(R.id.txtTime);
        txtDay = findViewById(R.id.txtDay);
        txtClass = findViewById(R.id.txtClass);
        btnSave = findViewById(R.id.btnSave);
        txtWarnDay = findViewById(R.id.txtWarnDay);
        txtWarnTime = findViewById(R.id.txtWarnTime);
        txtWarnLecture = findViewById(R.id.txtWarnLecture);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        init();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateData()) {
                    Toast.makeText(AddClass.this, "Clicked", Toast.LENGTH_SHORT).show();
                    LectureModel lectureModel = new LectureModel();
                    String name = txtClass.getText().toString();

                }
            }
        });
    }

    private boolean validateData() {
        if (txtDay.getText().toString().isEmpty()) {
            txtWarnDay.setText("Enter Day");
            return false;
        }
        txtWarnDay.setText("");
        if (txtTime.getText().toString().isEmpty()) {
            txtWarnTime.setText("Enter Time");
            return false;
        }
        txtWarnTime.setText("");
        if (txtClass.getText().toString().isEmpty()) {
            txtWarnLecture.setText("Enter Lecture");
            return false;
        }
        txtWarnLecture.setText("");
        return true;
    }
}