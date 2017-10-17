package com.marblemethodsoftware.nostroapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private Prophecy prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AnimatorUtil animator = new AnimatorUtil(this);

        textView = (TextView) findViewById(R.id.testingText);
        button = (Button) findViewById(R.id.getProphecy);


        final WordLibrary library = new WordLibrary(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Random rand = new Random();
            int seed = rand.nextInt(15);
                prof = new Prophecy(seed,  library);

                textView.setText(prof.getProphecyText());
                animator.animateText(textView);
            }
        });
    }
}