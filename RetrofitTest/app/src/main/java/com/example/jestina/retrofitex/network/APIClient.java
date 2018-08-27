package com.example.jestina.retrofitex.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import retrofit2.Retrofit;
import okhttp3.OkHttpClient;

/**
 * Created by JESTINA on 2018-08-27.
 *
 * retrofit 을 이용한 API 통신을 담당할 CLASS
 */

public class APIClient {
    private static Retrofit retrofit = null;

    static Retrofit getClient() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return null;
            }
        };

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory()
                .client(client)
                .build();

        return retrofit;
    }
}
