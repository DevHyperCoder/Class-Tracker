package com.codeyard.classtracker.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codeyard.classtracker.R;
import com.codeyard.classtracker.models.LectureModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LectureAdapter extends RecyclerView.Adapter<LectureAdapter.LectureAdapterViewHolder> {
    final String TAG = LectureAdapter.class.getName();
    private List<LectureModel> lectureModelList;

    public LectureAdapter(List<LectureModel> lectureModels) {
        this.lectureModelList = lectureModels;
    }

    @NonNull
    @Override
    public LectureAdapter.LectureAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_layout, parent, false);

        return new LectureAdapterViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull LectureAdapterViewHolder holder, int position) {
        holder.name.setText(lectureModelList.get(position).getName());
        holder.date.setText(lectureModelList.get(position).getDate().toString());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: sarted");
        for (int i =0;i<lectureModelList.size();i++){
            Log.d(TAG, "getItemCount: "+lectureModelList.get(i).getName());}
        Log.d(TAG, "getItemCount: "+lectureModelList.size());
        return lectureModelList.size();
    }

    public static class LectureAdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView name, date;

        public LectureAdapterViewHolder(View view) {
            super(view);
            this.name =
                    view.findViewById(R.id.upcoming_classes_name);
            this.date =
                    view.findViewById(R.id.upcoming_classes_date);
        }
    }
}
