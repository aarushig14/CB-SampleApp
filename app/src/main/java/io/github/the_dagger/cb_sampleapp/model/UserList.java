package io.github.the_dagger.cb_sampleapp.model;

import java.util.ArrayList;

/**
 * Created by Harshit on 2/4/2017
 */

public class UserList {

    private ArrayList<SingleUser> items;

    public ArrayList<SingleUser> getSingleUserArrayList() {
        return items;
    }

    public void setSingleUserArrayList(ArrayList<SingleUser> singleUserArrayList) {
        this.items = singleUserArrayList;
    }
}
