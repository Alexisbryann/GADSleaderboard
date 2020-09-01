package com.example.gadslearderboard.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit;
    private static final String BASE_URL = "https://gadsapi.herokuapp.com";
    public static final String GOOGLE_DOCS_BASE_URL ="https://docs.google.com/forms/d/e/";

    public static Api getClient(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        Api api = retrofit.create(Api.class);
        return api;
        }
        public static Retrofit getGoogleDocs(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(GOOGLE_DOCS_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
        }
    }
