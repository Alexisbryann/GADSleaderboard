package com.example.gadslearderboard.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkillModel {



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("country")
    @Expose
    private String Country;
    @SerializedName("badgeUrl")
    @Expose
    private String badgeUrl;
}
