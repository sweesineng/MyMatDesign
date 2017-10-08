package com.homenas.mymatdesign.activity;

/**
 * Created by Ravi on 29/07/15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.homenas.mymatdesign.R;
import com.homenas.mymatdesign.adapter.ListAdapter;
import com.homenas.mymatdesign.model.NavDrawerItem;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ListAdapter adapter;
    private static String[] titles = null;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static List<NavDrawerItem> getData() {
        List<NavDrawerItem> data = new ArrayList<>();

        // preparing navigation drawer items
        for (int i = 0; i < titles.length; i++) {
            NavDrawerItem navItem = new NavDrawerItem();
            navItem.setTitle(titles[i]);
            Log.i("HomeFragment", navItem.getTitle().toString());
            data.add(navItem);
        }
        return data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        titles = getActivity().getResources().getStringArray(R.array.nav_drawer_labels);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.HomeList);
        adapter = new ListAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
