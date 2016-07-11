package com.example.pablo.tabsexample.network;

import com.example.pablo.tabsexample.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Alex on 6/16/2016.
 */
public interface UserService {
    @GET("users.json")
    Call<List<User>> getUsers();
}
