package com.hari.sampleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.hari.sampleproject.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String DATA_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";
    private RecyclerView mRecyclerView;
    private List<ListItem> mDataList = new ArrayList<>();
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolBar = findViewById(R.id.toolbar);
        //Setting toolbar for Screen title
        setSupportActionBar(mToolBar);

        mRecyclerView = findViewById(R.id.recyclerView);
        //Setting up layoutmanager for Recyclerview to form List that scrolls vertically
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }
}
