package com.marblemethodsoftware.nostroapp.UI;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.marblemethodsoftware.nostroapp.Utils.AnimatorUtil;
import com.marblemethodsoftware.nostroapp.Model.LanguageLibrary;
import com.marblemethodsoftware.nostroapp.Model.Prophecy;
import com.marblemethodsoftware.nostroapp.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageButton imageButton;
    private Prophecy prof;
    private LanguageLibrary library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AnimatorUtil animator = new AnimatorUtil(this);

        textView = (TextView) findViewById(R.id.testingText);
        Typeface face = Typeface.createFromAsset(getAssets(),"Caveat-Regular.ttf");
        textView.setTypeface(face);
        imageButton = (ImageButton) findViewById(R.id.getProphecy);
        library = new LanguageLibrary(this);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prof = new Prophecy(library);
                textView.setText(prof.getProphecyText());
                animator.fadeText(textView);
                animator.rotateAndDepressButton(imageButton);
            }
        });
    }
}
