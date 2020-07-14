package com.codeyard.classtracker;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codeyard.classtracker.adapters.LectureAdapter;
import com.codeyard.classtracker.db.DBHelper;
import com.codeyard.classtracker.models.LectureModel;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    final String TAG = CardFragment.class.getName();
    RecyclerView upcomingClassesRecyclerView;
    List<LectureModel> lectures;
    LectureAdapter lectureAdapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView.Adapter mAdapter;

    public CardFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CardFragment newInstance(String param1, String param2) {
        CardFragment fragment = new CardFragment();
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
        View view = inflater.inflate(R.layout.fragment_card, container, false);

        upcomingClassesRecyclerView = view.findViewById(R.id.upcoming_classes_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Log.d(TAG, "onCreateView: " + requireActivity().toString());

        upcomingClassesRecyclerView.setLayoutManager(layoutManager);

        lectures = DBHelper.getAllLectures();
        lectureAdapter = new LectureAdapter(lectures);
        upcomingClassesRecyclerView.setAdapter(lectureAdapter);

        return view;
    }
}