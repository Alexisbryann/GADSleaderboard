package com.example.gadslearderboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.gadslearderboard.adapters.LearningAdapter;
import com.example.gadslearderboard.data.model.LearningModel;
import com.example.gadslearderboard.data.network.Api;
import com.example.gadslearderboard.data.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLearningLeaders extends Fragment {

    private RecyclerView mRecyclerView;
    private TextView mTextView;
    private TextView mTextView1;
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private LinearLayoutManager mLayoutManager;

    public FragmentLearningLeaders() {
        // Required empty public constructor
    }

//    public static FragmentLearningLeaders newInstance(String param1, String param2) {
//
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_learning_leaders,container,false);
        mRecyclerView = view.findViewById(R.id.recycler_view_learning_leaders);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mTextView = view.findViewById(R.id.textView_top_learner_name);
        mTextView1 = view.findViewById(R.id.textView_top_learner_hours_and_country);
        mImageView = view.findViewById(R.id.imageView_top_learner);
        mProgressBar = new ProgressBar(getContext());

        getLearners();
        return view;
    }

    private void getLearners() {
ApiClient.getClient().getLearningLeaders().enqueue(new Callback<List<LearningModel>>() {
//    @Override
//    public void onResponse(Call<List<LearningModel>> call, Response<List<LearningModel>> response) {
//
//    }
//
//    @Override
//    public void onFailure(Call<List<LearningModel>> call, Throwable t) {

//    }
//});
//        Api service = ApiClient.getClient().create(Api.class);
//        Call<List<LearningModel>> call = service.getLearningLeaders();
//        call.enqueue(new Callback<List<LearningModel>>()
//        {

            private List<LearningModel> mLearningModelList;
            private LearningAdapter mLearningAdapter;

            @Override
            public void onResponse(Call<List<LearningModel>> call, Response<List<LearningModel>> response) {
                if (response.isSuccessful()){
                    mLearningModelList = response.body();
                    mLearningAdapter = new  LearningAdapter(getContext(), mLearningModelList);
                    mRecyclerView.setAdapter(mLearningAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    mProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<LearningModel>> call, Throwable t) {

                mTextView.setText(t.getMessage());
                mTextView1.setText(t.getMessage());
                mTextView.setVisibility(View.VISIBLE);
                mTextView1.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }
}