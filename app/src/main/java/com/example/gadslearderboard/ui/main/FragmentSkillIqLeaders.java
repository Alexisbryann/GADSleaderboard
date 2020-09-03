package com.example.gadslearderboard.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gadslearderboard.R;
import com.example.gadslearderboard.adapters.SkillIqAdapter;
import com.example.gadslearderboard.data.model.SkillModel;
import com.example.gadslearderboard.data.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentSkillIqLeaders extends Fragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ImageView mImageView;
    private TextView mTextView1;
    private TextView mTextView;

    public FragmentSkillIqLeaders() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_skill_iq_leaders,container,false);
        mRecyclerView = view.findViewById(R.id.recycler_view_skill_iq);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mTextView = view.findViewById(R.id.text_view_name);
        mTextView1 = view.findViewById(R.id.text_view_skill_iq_score_and_country);
        mImageView = view.findViewById(R.id.image_view_skill_IQ);

        getSkillIQ();
        return view;
    }

    private void getSkillIQ() {
        ApiClient.getClient().getSkillIqLeaders().enqueue(new Callback<List<SkillModel>>() {

            @Override
            public void onResponse(Call<List<SkillModel>> call, Response<List<SkillModel>> response) {
                if (response.isSuccessful()){
                    List<SkillModel> skillModelList = response.body();
                    SkillIqAdapter skillIqAdapter = new SkillIqAdapter(getContext(), skillModelList);
                    mRecyclerView.setAdapter(skillIqAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                }
            }
            @Override
            public void onFailure(Call<List<SkillModel>> call, Throwable t) {
                mTextView.setText(t.getMessage());
                mTextView1.setText(t.getMessage());
                mTextView.setVisibility(View.VISIBLE);
                mTextView1.setVisibility(View.VISIBLE);
            }
        });
    }
}