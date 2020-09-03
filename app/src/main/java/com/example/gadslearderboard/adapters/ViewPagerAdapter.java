package com.example.gadslearderboard.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gadslearderboard.FragmentLearningLeaders;
import com.example.gadslearderboard.FragmentSkillIqLeaders;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position==0){
            fragment = new FragmentLearningLeaders();
        }else if(position==1){
            fragment = new FragmentSkillIqLeaders();
        }
        return fragment;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String title = null;
        if (position==0) title = "Learning leaders";
        else if(position==1) title = "skill iq leaders";
        return title;
    }

    @Override
    public int getCount() {

        return 2 ;
    }
}
