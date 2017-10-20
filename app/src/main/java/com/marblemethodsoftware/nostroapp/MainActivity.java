package com.marblemethodsoftware.nostroapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.marblemethodsoftware.nostroapp.Animations.AnimatorUtil;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private Prophecy prof;
    private LanguageLibrary library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AnimatorUtil animator = new AnimatorUtil(this);

        textView = (TextView) findViewById(R.id.testingText);
        button = (Button) findViewById(R.id.getProphecy);
        library = new LanguageLibrary(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prof = new Prophecy(library);
                textView.setText(prof.getProphecyText());
                animator.animateText(textView);
            }
        });
    }
}
