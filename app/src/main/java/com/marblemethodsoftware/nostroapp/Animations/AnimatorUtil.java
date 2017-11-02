package com.marblemethodsoftware.nostroapp.Animations;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.marblemethodsoftware.nostroapp.R;

public class AnimatorUtil {
    private Context mContext;

    public AnimatorUtil(Context context) {
        mContext = context;
    }

    public void animateButton(Button button){

        Animator scaleButton = AnimatorInflater.loadAnimator(mContext, R.animator.scale);
        scaleButton.setTarget(button);
        scaleButton.start();
    }

    public void animateButton(ImageButton button){
        Animator scaleButton = AnimatorInflater.loadAnimator(mContext, R.animator.scale);
        scaleButton.setTarget(button);
        scaleButton.start();
    }

    public void animateText(TextView text){

        Animator fadeText = AnimatorInflater.loadAnimator(mContext, R.animator.fade);
        fadeText.setTarget(text);
        fadeText.start();
    }

    public void rotateAndDepress(ImageButton button){
        Animator scaleButton = AnimatorInflater.loadAnimator(mContext, R.animator.scale);
        scaleButton.setTarget(button);
        scaleButton.start();

        RotateAnimation animation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(500);
        button.startAnimation(animation);


    }


}
