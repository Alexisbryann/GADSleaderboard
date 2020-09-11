package com.example.gadslearderboard.data.network;

import java.util.logging.Level;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit = null;
    private static final String BASE_URL = "https://gadsapi.herokuapp.com";
    public static final String GOOGLE_DOCS_BASE_URL ="https://docs.google.com/forms/d/e/";

    public static Api getClient(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        Api api = retrofit.create(Api.class);
        return api;
        }
        public static Api getGoogleDocsClient(){
             retrofit = null;
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(logging);
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(GOOGLE_DOCS_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
            Api api = retrofit.create(Api.class);
            return api;
        }
    }
