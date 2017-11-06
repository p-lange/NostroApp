package com.marblemethodsoftware.nostroapp.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.marblemethodsoftware.nostroapp.R;

public class PriorPropheciesActivity extends AppCompatActivity {

    private String[] prophecies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prior_prophecies);

        Intent intent = getIntent();
        prophecies = intent.getStringArrayExtra("PROPHECIES_KEY");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ProphecyListAdapter adapter = new ProphecyListAdapter(prophecies);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }
}
