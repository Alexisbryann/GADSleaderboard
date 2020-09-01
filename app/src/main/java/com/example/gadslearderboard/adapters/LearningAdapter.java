package com.example.gadslearderboard.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gadslearderboard.R;
import com.example.gadslearderboard.data.model.LearningModel;

import java.util.List;

public class LearningAdapter extends RecyclerView.Adapter<LearningAdapter.LearningViewHolder> {

    private final Context mContext;
    private final List<LearningModel> mLearningModelList;

    public LearningAdapter(Context context, List<LearningModel> LearningList){
        mContext = context;
        mLearningModelList = LearningList;
    }
    @NonNull
    @Override
    public LearningAdapter.LearningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
        View learningView = layoutInflater.inflate(R.layout.item_learning_leaders,parent,false);

        return new LearningViewHolder(learningView);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull LearningAdapter.LearningViewHolder holder, int position) {

        holder.mName.setText(mLearningModelList.get(position).getName());
        holder.mHoursAndCountry.setText(mLearningModelList.get(position).getHours()+mContext.getString(R.string.learning_hours)+mLearningModelList.get(position).getCountry());
        Glide.with(mContext).load(mLearningModelList.get(position).getBadgeUrl())
                .centerCrop().into(holder.mBadge);
    }

    @Override
    public int getItemCount() {
        return mLearningModelList.size();
    }

    public static class LearningViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mBadge;
        private final TextView mName;
        private final TextView mHoursAndCountry;

        public LearningViewHolder(@NonNull View itemView) {
            super(itemView);
            mBadge = itemView.findViewById(R.id.imageView_top_learner);
            mName = itemView.findViewById(R.id.textView_top_learner_name);
            mHoursAndCountry = itemView.findViewById(R.id.textView_top_learner_hours_and_country);
        }
    }
}
