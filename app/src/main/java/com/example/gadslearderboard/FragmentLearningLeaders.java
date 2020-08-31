package com.example.gadslearderboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLearningLeaders#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLearningLeaders extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRecyclerView;
    private TextView mTextView;
    private TextView mTextView1;
    private ImageView mImageView;

    public FragmentLearningLeaders() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLearningLeaders.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLearningLeaders newInstance(String param1, String param2) {
        FragmentLearningLeaders fragment = new FragmentLearningLeaders();
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
        View view = inflater.inflate(R.layout.fragment_learning_leaders,container,false);
        mRecyclerView = view.findViewById(R.id.recycler_view_learning_leaders);
        mTextView = view.findViewById(R.id.textView_top_learner_name);
        mTextView1 = view.findViewById(R.id.textView_top_learner_hours_and_country);
        mImageView = view.findViewById(R.id.imageView_top_learner);

        getLearners();
        return view;
    }

    private void getLearners() {
    }
}