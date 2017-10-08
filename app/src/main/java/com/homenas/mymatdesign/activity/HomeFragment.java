package com.homenas.mymatdesign.activity;

/**
 * Created by Ravi on 29/07/15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.homenas.mymatdesign.R;
import com.homenas.mymatdesign.adapter.ListAdapter;
import com.homenas.mymatdesign.model.HomeDrawerItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ListAdapter adapter;
    private static String[] titles = null;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static List<HomeDrawerItem> getData() {
        List<HomeDrawerItem> data = new ArrayList<>();

        File root = new File(Environment.getExternalStorageDirectory().toString());
        File[] files = root.listFiles();
        for (File file : files) {
            HomeDrawerItem homeItem = new HomeDrawerItem();
            homeItem.setTitle(file.getName());
            data.add(homeItem);
            Log.i("Recyclerview", "list: " + file.getName());
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
