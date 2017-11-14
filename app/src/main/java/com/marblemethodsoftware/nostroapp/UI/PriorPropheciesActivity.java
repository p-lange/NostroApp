package com.marblemethodsoftware.nostroapp.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import com.marblemethodsoftware.nostroapp.R;
import com.marblemethodsoftware.nostroapp.Utils.AnimatorUtil;

public class PriorPropheciesActivity extends AppCompatActivity {

    private String[] prophecies;
    private ImageButton clearPropheciesButton;
    private SharedPreferences storedProphecies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prior_prophecies);
        Intent intent = getIntent();
        prophecies = intent.getStringArrayExtra("PROPHECIES_KEY");
        final AnimatorUtil animator = new AnimatorUtil(this);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        clearPropheciesButton = (ImageButton) findViewById(R.id.clearProphecies);
        final ProphecyListAdapter adapter = new ProphecyListAdapter(prophecies);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        clearPropheciesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animator.depressButton(clearPropheciesButton);
                storedProphecies = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = storedProphecies.edit();
                editor.clear();
                editor.apply();
                finish();




            }
        });

    }
}
