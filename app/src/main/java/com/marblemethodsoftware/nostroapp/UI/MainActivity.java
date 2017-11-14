package com.marblemethodsoftware.nostroapp.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.marblemethodsoftware.nostroapp.Utils.AnimatorUtil;
import com.marblemethodsoftware.nostroapp.Model.LanguageLibrary;
import com.marblemethodsoftware.nostroapp.Model.Prophecy;
import com.marblemethodsoftware.nostroapp.R;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String STORED_PROPHECIES_KEY = "STORED_PROPHECIES_KEY";
    private TextView textView;
    private ImageButton imageButton;
    private Prophecy prof;
    private LanguageLibrary library;
    private static final String PROPHECIES_KEY = "PROPHECIES_KEY";
    private SharedPreferences storedProphecies;
    private ImageButton storedPropheciesButton;
    private String CONTEXT_KEY = "CONTEXT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storedProphecies = PreferenceManager.getDefaultSharedPreferences(this);

        final AnimatorUtil animator = new AnimatorUtil(this);

        textView = (TextView) findViewById(R.id.testingText);
        Typeface face = Typeface.createFromAsset(getAssets(),"Caveat-Regular.ttf");
        textView.setTypeface(face);
        textView.setText("");
        imageButton = (ImageButton) findViewById(R.id.getProphecy);
        storedPropheciesButton = (ImageButton) findViewById(R.id.storedPropheciesButton);
        library = new LanguageLibrary(this);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prof = new Prophecy(library);
                textView.setText(prof.getProphecyText());
                animator.fadeText(textView);
                animator.rotateAndDepressButton(imageButton);
                addProphecyToSavedList(prof.getProphecyText());
            }
        });


        storedPropheciesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PriorPropheciesActivity.class);
                Set<String> prophecies = storedProphecies.getStringSet(PROPHECIES_KEY, null);
                textView.setText("");

                if (prophecies != null) {
                    String[] prophecyArray = prophecies.toArray(new String[0]);
                    intent.putExtra(PROPHECIES_KEY, prophecyArray);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "No saved prophecies.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void addProphecyToSavedList(String prophecy){
        Set<String> stringSet = new HashSet<>();
        Set<String> prophecies = storedProphecies.getStringSet(PROPHECIES_KEY, stringSet);
        prophecies.add(prophecy);
        SharedPreferences.Editor editor = storedProphecies.edit();
        editor.clear();
        editor.putStringSet(PROPHECIES_KEY, prophecies);
        editor.apply();
    }
}
