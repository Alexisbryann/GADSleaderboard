package com.example.gadslearderboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        Context context = this.mContext;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View skillView = layoutInflater.inflate(R.layout.item_skill_iq_leaders,parent,false);

        return new SkillIqViewHolder(skillView);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIqAdapter.SkillIqViewHolder holder, int position) {
//        holder.itemView.
    }

    @Override
    public int getItemCount() {
        return mSkillModelList.size();
    }

    public class SkillIqViewHolder extends RecyclerView.ViewHolder {
        public SkillIqViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
