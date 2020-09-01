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
        switch (position){
            case 0:
                return new FragmentLearningLeaders();
            case 1:
                return new FragmentSkillIqLeaders();
        }
        return null;
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
