package io.github.the_dagger.cb_sampleapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import io.github.the_dagger.cb_sampleapp.R;
import io.github.the_dagger.cb_sampleapp.adapters.MovieAdapter;
import io.github.the_dagger.cb_sampleapp.model.SingleUser;
import io.github.the_dagger.cb_sampleapp.model.UserList;
import io.github.the_dagger.cb_sampleapp.rest.TheMovieDbApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    MovieAdapter movieAdapter;
    ArrayList<SingleUser> singleUserArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        singleUserArrayList = new ArrayList<>();
        movieAdapter = new MovieAdapter(singleUserArrayList);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TheMovieDbApi theMovieDbApi = new TheMovieDbApi();

        theMovieDbApi.getGithubClient().getUsers().enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                singleUserArrayList.addAll(response.body().getSingleUserArrayList());
                movieAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

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
