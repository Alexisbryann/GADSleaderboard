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
import com.example.gadslearderboard.data.model.SkillModel;

import java.util.List;

public class SkillIqAdapter extends RecyclerView.Adapter<SkillIqAdapter.SkillIqViewHolder> {

    private final Context mContext;
    private final List<SkillModel> mSkillModelList;

    public SkillIqAdapter(Context context, List<SkillModel> SkillList){
        mContext = context;
        mSkillModelList = SkillList;
    }
    @NonNull
    @Override
    public SkillIqAdapter.SkillIqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
        View skillView = layoutInflater.inflate(R.layout.item_skill_iq_leaders,parent,false);

        return new SkillIqViewHolder(skillView);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SkillIqAdapter.SkillIqViewHolder holder, int position) {
        holder.mName.setText(mSkillModelList.get(position).getName());
        holder.mScoreAndCountry.setText(mSkillModelList.get(position).getScore()+" Skill IQ Score ,"+mSkillModelList.get(position).getCountry());
        Glide.with(mContext).load(mSkillModelList.get(position).getBadgeUrl()).centerCrop().into(holder.mBadge);
    }

    @Override
    public int getItemCount() {
        return mSkillModelList.size();
    }

    public static class SkillIqViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mBadge;
        private final TextView mName;
        private final TextView mScoreAndCountry;

        public SkillIqViewHolder(@NonNull View itemView) {
            super(itemView);
            mBadge = itemView.findViewById(R.id.image_view_skill_IQ);
            mName = itemView.findViewById(R.id.text_view_name);
            mScoreAndCountry = itemView.findViewById(R.id.text_view_skill_iq_score_and_country);
        }
    }
}
