package com.codeyard.classtracker;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.codeyard.classtracker.models.DateTimeModel;
import com.codeyard.classtracker.models.LectureModel;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddLectureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddLectureFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    final String TAG = AddLectureFragment.class.getName();
    // TODO: Rename and change types of parameters
    private TextView txtTime;
    private EditText txtClass;
    private Button btnSave;
    private TextView txtWarnTime;
    private TextView txtWarnLecture;
    private TextView dateTextView;
    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;



    public AddLectureFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddLectureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddLectureFragment newInstance() {
        AddLectureFragment fragment = new AddLectureFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_lecture, container, false);

        //Get all the view instances
        txtTime = view.findViewById(R.id.txtTime);
        txtClass = view.findViewById(R.id.txtClass);
        btnSave = view.findViewById(R.id.btnSave);
        txtWarnTime = view.findViewById(R.id.txtWarnTime);
        txtWarnLecture = view.findViewById(R.id.txtWarnLecture);
        dateTextView = view.findViewById(R.id.dateTextView);

        DateTimeModel dateTimeModel = new DateTimeModel();

        dateTextView.setOnClickListener(view14 -> {
            datePickerDialog = DatePickerDialog.newInstance((view141, year, monthOfYear, dayOfMonth) -> {
                String dateString = "";
                dateTimeModel.setDate(year, dayOfMonth, monthOfYear);
                dateString = dateTimeModel.getDateString();

                dateTextView.setText(dateString);
            }, Calendar.getInstance());
            datePickerDialog.show(requireFragmentManager(), TAG);
        });

        txtTime.setOnClickListener(view13 -> {
            timePickerDialog = TimePickerDialog.newInstance((view12, hourOfDay, minute, second) -> {
                Log.d(TAG, "onTimeSet: " + hourOfDay);
                Log.d(TAG, "onTimeSet: " + minute);
                Log.d(TAG, "onTimeSet: " + second);

                String timeString = "";

                dateTimeModel.setTime(hourOfDay,minute,second);
                timeString=dateTimeModel.getTimeString();

                txtTime.setText(timeString);

            }, false);
            timePickerDialog.show(requireFragmentManager(), TAG);
        });
        btnSave.setOnClickListener(view1 -> {
            int hour = timePickerDialog.getSelectedTime().getHour();
            int minute = timePickerDialog.getSelectedTime().getMinute();
            int second = timePickerDialog.getSelectedTime().getSecond();
            int year = datePickerDialog.getSelectedDay().getYear();
            int monthOfYear = datePickerDialog.getSelectedDay().getMonth();
            int dayOfMonth = datePickerDialog.getSelectedDay().getDay();


            dateTimeModel.setDate(year, dayOfMonth, monthOfYear);
            dateTimeModel.setTime(hour, minute, second);

            Date date = dateTimeModel.getDate();

            String name = txtClass.getText().toString();

            LectureModel lectureModel = new LectureModel(name, date);
            lectureModel.save();

            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.popBackStackImmediate();
            }

        });
        return view;
    }

}