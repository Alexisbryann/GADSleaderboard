package com.example.gadslearderboard.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.gadslearderboard.R;

import java.util.Objects;

public class SubmissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.submission_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        getSupportActionBar(toolbar);
toolbar.setNavigationOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        onBackPressed();
    }
});

    }

    private void getSupportActionBar(Toolbar toolbar) {

    }

}
