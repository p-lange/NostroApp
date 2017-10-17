package com.marblemethodsoftware.nostroapp;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

public class AnimatorUtil {
    Context mContext;

    public AnimatorUtil(Context context) {
        mContext = context;
    }

    public void animateButton(Button button){

        Animator scaleButton = AnimatorInflater.loadAnimator(mContext, R.animator.scale);
        scaleButton.setTarget(button);
        scaleButton.start();
    }

    public void animateText(TextView text){

        Animator fadeText = AnimatorInflater.loadAnimator(mContext, R.animator.fade);
        fadeText.setTarget(text);
        fadeText.start();
    }


}
