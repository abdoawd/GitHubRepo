package com.example.abdulrahman.githubrepo.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    private static Retrofit retrofit;
    private static ApiService apiService;

    private ApiClient() {
    }

    private static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ApiService getApiService() {
        if (apiService == null)
            apiService = getRetrofitInstance().create(ApiService.class);
        return apiService;
    }
}