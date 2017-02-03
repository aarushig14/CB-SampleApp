package io.github.the_dagger.cb_sampleapp.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Harshit on 2/3/2017
 */

public class TheMovieDbApi {

    public MovieClient getMovieClient() {
        String BASE_URL = "https://api.themoviedb.org/3/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MovieClient.class);
    }

    public MovieClient getGithubClient() {
        String BASE_URL = "https://api.github.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MovieClient.class);
    }
}
