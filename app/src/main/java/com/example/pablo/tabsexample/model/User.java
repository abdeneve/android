package com.example.pablo.tabsexample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 6/16/2016.
 */
public class User {
    private int id;
    private String username;
    private String email;
    private String pictureUrl;
    private List<Post> posts;

    public User() {
        id = 0;
        username = "";
        email = "";
        pictureUrl = "";
        posts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
