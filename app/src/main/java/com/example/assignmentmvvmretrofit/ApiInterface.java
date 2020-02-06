package com.example.assignmentmvvmretrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    String JSONURL = "http://101.53.139.161:5000/";
    @GET("bids")
    Call<String> getString();
}
