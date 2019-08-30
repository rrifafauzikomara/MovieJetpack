package com.rifafauzi.moviecatalogue.helper.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rifafauzi.moviecatalogue.adapter.Contract;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiClient {

    static Retrofit getClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        // start converter json
        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder().baseUrl(Contract.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).client(httpClient.build()).build();
    }

}