package io.github.the_dagger.cb_sampleapp.model;

import java.util.ArrayList;

/**
 * Created by Harshit on 2/3/2017
 */
public class MovieList{

    private ArrayList<SingleMovie> results;

    public ArrayList<SingleMovie> getResults() {
        return results;
    }

    public void setResults(ArrayList<SingleMovie> results) {
        this.results = results;
    }
}