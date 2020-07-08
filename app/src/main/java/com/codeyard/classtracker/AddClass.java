package com.codeyard.classtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class AddClass extends AppCompatActivity {
    private TextView txtTime;
    private TextView txtDay;
    private TextView txtClass;
    private Button btnSave;

    public void init(){
        txtTime = findViewById(R.id.txtTime);
        txtDay = findViewById(R.id.txtDay);
        txtClass = findViewById(R.id.txtClass);
        btnSave = findViewById(R.id.btnSave);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        init();

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
        if (txtDay.getText().toString().isEmpty()){
            Toast.makeText(AddClass.this,"Empty Day",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtTime.getText().toString().isEmpty()){
            Toast.makeText(AddClass.this,"Empty time",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtClass.getText().toString().isEmpty()){
            Toast.makeText(AddClass.this,"Empty Class",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}