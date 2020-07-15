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

import static com.codeyard.classtracker.constants.Constants.ITEM_NORMAL;

public class LectureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final String TAG = LectureAdapter.class.getName();
    private List<LectureModel> lectureModelList;

    public LectureAdapter(List<LectureModel> lectureModels) {
        this.lectureModelList = lectureModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        Log.d(TAG, "onCreateViewHolder: "+viewType);

        View view ;
        if (viewType == ITEM_NORMAL) {
            view = layoutInflater.inflate(R.layout.card_layout, parent, false);
            return new LectureAdapterViewHolder(view);
        } else  {
            view = layoutInflater.inflate(R.layout.card_header_layout, parent, false);
            return  new LectureAdapterHeaderViewHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final int itemViewType = getItemViewType(position);
        if (itemViewType == ITEM_NORMAL){
        ((LectureAdapterViewHolder)holder).name.setText(lectureModelList.get(position).getName());
        ((LectureAdapterViewHolder)holder).date.setText(lectureModelList.get(position).getDate().toString());}
        else {
            ((LectureAdapterHeaderViewHolder)holder).headerTextView.setText(lectureModelList.get(position).getHeading());
        }
    }

    @Override
    public int getItemCount() {
        return lectureModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        LectureModel lectureModel = lectureModelList.get(position);
        Log.d(TAG, "getItemViewType: "+lectureModel.getViewType());
        return lectureModel.getViewType();

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

    public static class LectureAdapterHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView headerTextView;

        public LectureAdapterHeaderViewHolder(View view) {
            super(view);
            this.headerTextView = view.findViewById(R.id.heading_text_view);
        }
    }
}
