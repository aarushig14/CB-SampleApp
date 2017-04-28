package io.github.the_dagger.cb_sampleapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import io.github.the_dagger.cb_sampleapp.R;
import io.github.the_dagger.cb_sampleapp.adapters.MovieAdapter;
import io.github.the_dagger.cb_sampleapp.model.MovieList;
import io.github.the_dagger.cb_sampleapp.model.SingleMovie;
import io.github.the_dagger.cb_sampleapp.rest.TheMovieDbApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<SingleMovie> singleMovieArrayList;
    MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        singleMovieArrayList = new ArrayList<>();
        movieAdapter = new MovieAdapter(singleMovieArrayList);

        final TheMovieDbApi theMovieDbApi = new TheMovieDbApi();
        theMovieDbApi.getMovieClientGET().getMovieList().enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                for (SingleMovie singleMovie : response.body().getResults()){
                    Log.e("Movie",singleMovie.getOriginalTitle());
                    singleMovieArrayList.add(singleMovie);
                }
                movieAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {

            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movieRecyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(movieAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
