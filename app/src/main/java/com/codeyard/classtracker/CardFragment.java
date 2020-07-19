package com.codeyard.classtracker;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codeyard.classtracker.adapters.LectureAdapter;
import com.codeyard.classtracker.constants.Constants;
import com.codeyard.classtracker.db.DBHelper;
import com.codeyard.classtracker.models.LectureModel;
import com.codeyard.classtracker.notification.NotificationHelper;

import java.util.List;

import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardFragment extends Fragment {

    final String TAG = CardFragment.class.getName();

    RecyclerView upcomingClassesRecyclerView;

    List<LectureModel> lectures;
    LectureAdapter lectureAdapter;

    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);

        upcomingClassesRecyclerView = view.findViewById(R.id.upcoming_classes_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Log.d(TAG, "onCreateView: " + requireActivity().toString());

        upcomingClassesRecyclerView.setLayoutManager(layoutManager);

        lectures = DBHelper.getAllLectures();
        for (int i = 0; i < lectures.size(); i++) {
            lectures.get(i).setViewType(Constants.ITEM_NORMAL);
        }

        LectureModel lectureModel = new LectureModel();
        lectureModel.setViewType(Constants.ITME_HEADER);
        lectureModel.setHeading("alheading");
        lectures.add(lectureModel);

        lectureAdapter = new LectureAdapter(lectures);
        upcomingClassesRecyclerView.setAdapter(lectureAdapter);

//        Create a notification channel if the version is >= 26
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O && NotificationManagerCompat.from(requireActivity()).getNotificationChannel("classChannelID") == null) {
            NotificationHelper.createClassChannel(requireActivity());
        }

        return view;
    }
}