package com.example.gadslearderboard.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.gadslearderboard.R;

public class SubmissionActivity extends AppCompatActivity {

    private TextView mProjectSubmission;
    private TextView mFirstName;
    private TextView mSecondName;
    private TextView mEmailAddress;
    private TextView mGitHubLink;
    private Button mSubmitActivity;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.submission_activity);

        mToolbar = findViewById(R.id.toolbar);
        mProjectSubmission = findViewById(R.id.text_view_project_submission);
        mFirstName = findViewById(R.id.editTextTextFirstName);
        mSecondName = findViewById(R.id.editTextTextLastName);
        mEmailAddress = findViewById(R.id.text_view_email_address);
        mGitHubLink = findViewById(R.id.editTextTextGithubLink);
        mSubmitActivity = findViewById(R.id.button_submit_activity);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        onBackPressed();
    }
});
    }
}
