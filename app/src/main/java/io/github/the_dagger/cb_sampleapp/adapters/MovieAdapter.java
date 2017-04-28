package io.github.the_dagger.cb_sampleapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.the_dagger.cb_sampleapp.R;
import io.github.the_dagger.cb_sampleapp.model.SingleMovie;

/**
 * Created by Harshit on 2/3/2017
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<SingleMovie> movies;
    private Context context;

    public MovieAdapter(ArrayList<SingleMovie> movieArrayList){
        movies = movieArrayList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_movie,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(movies.get(position).getOriginalTitle());
        String poster = "http://image.tmdb.org/t/p/w500" + movies.get(position).getPosterPath();
        //TODO : Add Picasso
        //TODO : remove fit and check what happens
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.movie_name);
            imageView = (ImageView) itemView.findViewById(R.id.movie_image);
        }
    }
}
