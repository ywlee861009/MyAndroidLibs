package com.example.jestina.retrofitex.network;

import com.example.jestina.retrofitex.network.response.MultipleResources;
import com.example.jestina.retrofitex.network.response.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by JESTINA on 2018-08-27.
 *
 * Retrofit 을 이용한 통신 Interface
 */
public interface APIInterface {
    @GET("api/unknown")
    Call<MultipleResources> doGetListResources();

    @POST("api/users")
    Call<User> createUser(@Body User user);
}
