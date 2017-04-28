package io.github.the_dagger.cb_sampleapp.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Harshit on 2/3/2017
 */

public class TheMovieDbApi {

    public MovieClient getMovieClientGET() {
        String BASE_URL = "https://api.themoviedb.org/3/";

        /**GSON is used for converting JSON to POJO and Vice versa.
         * Check {@link com.google.gson.Gson} to see some examples
         */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(MovieClient.class);
    }

    public MovieClient getMovieClientPOST() {
        String BASE_URL_POST = "http://posttestserver.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_POST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(MovieClient.class);
    }

}
