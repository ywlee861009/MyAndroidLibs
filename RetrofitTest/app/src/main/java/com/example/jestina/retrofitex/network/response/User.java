package com.example.jestina.retrofitex.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JESTINA on 2018-08-27.
 */

public class User extends BaseResponse {
    @SerializedName("name")
    public String name;
    @SerializedName("job")
    public String job;
    @SerializedName("id")
    public String id;
    @SerializedName("createAt")
    public String createAt;

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
