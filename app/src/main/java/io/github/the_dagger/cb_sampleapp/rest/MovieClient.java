package io.github.the_dagger.cb_sampleapp.rest;

import io.github.the_dagger.cb_sampleapp.model.MovieList;
import io.github.the_dagger.cb_sampleapp.model.SingleMovie;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Harshit on 2/3/2017
 */

public interface MovieClient {

    @GET("movie/popular?api_key=97f469b9e89b30f1f7d07e8b35973e56&page=1&language=en-US")
    Call<MovieList> getMovieList();

    @POST("/post.php")
    Call<ResponseBody> sendPost(@Body SingleMovie singleMovie);

    //TODO 1 : Consume Github API for user names (https://api.github.com/search/users?q=harshit)
    // and (https://api.github.com/users/{the-dagger}/repos) (Path) and (Query)

    //TODO 2 : Send a POST request of github user name

    //TODO 3 : Dynamic path in URL
}
