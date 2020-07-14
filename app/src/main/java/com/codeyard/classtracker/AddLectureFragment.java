package com.codeyard.classtracker;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codeyard.classtracker.models.LectureModel;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;
import java.util.Date;

import androidx.fragment.app.Fragment;

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
    private String mParam1;
    private String mParam2;
    private EditText txtTime;
    private EditText txtClass;
    private Button btnSave;
    private TextView txtWarnTime;
    private TextView txtWarnLecture;
    private TextView daySpinner;
    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;

    public AddLectureFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddLectureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddLectureFragment newInstance(String param1, String param2) {
        AddLectureFragment fragment = new AddLectureFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
        daySpinner = view.findViewById(R.id.editTextDate);

        daySpinner.setOnClickListener(view14 -> {
            datePickerDialog = DatePickerDialog.newInstance((view141, year, monthOfYear, dayOfMonth) -> {
                Log.d(TAG, "onDateSet: " + year);
                Log.d(TAG, "onDateSet: " + monthOfYear);
                Log.d(TAG, "onDateSet: " + dayOfMonth);
            }, Calendar.getInstance());
            datePickerDialog.show(requireFragmentManager(), TAG);
        });

        txtTime.setOnClickListener(view13 -> {
            timePickerDialog = TimePickerDialog.newInstance((view12, hourOfDay, minute, second) -> {
                Log.d(TAG, "onTimeSet: " + hourOfDay);
                Log.d(TAG, "onTimeSet: " + minute);
                Log.d(TAG, "onTimeSet: " + second);
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

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);
            calendar.set(Calendar.SECOND, second);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.YEAR, year);

            Date date = calendar.getTime();
            String name = txtClass.getText().toString();

            LectureModel lectureModel = new LectureModel(name, date);
            lectureModel.save();

        });
        return view;
    }
}