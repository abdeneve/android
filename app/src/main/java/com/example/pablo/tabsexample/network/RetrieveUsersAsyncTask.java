package com.example.pablo.tabsexample.network;

import android.os.AsyncTask;

import com.example.pablo.tabsexample.UserFragment;
import com.example.pablo.tabsexample.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alex on 6/16/2016.
 */
public class RetrieveUsersAsyncTask extends AsyncTask<Void, Void, List<User>> {
    private UserFragment fragment;

    public RetrieveUsersAsyncTask(UserFragment userFragment) {
        this.fragment = userFragment;
    }

    @Override
    protected List<User> doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dip-androiducbv2.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService service = retrofit.create(UserService.class);
        Call<List<User>> call = service.getUsers();

        try {
            Response<List<User>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(List<User> users) {
        fragment.getAdapter().clear();
        fragment.getAdapter().addAll(users);
    }
}
