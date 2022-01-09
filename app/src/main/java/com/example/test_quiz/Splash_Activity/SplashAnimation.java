package com.example.test_quiz.Splash_Activity;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.example.test_quiz.Chat_Section.Chat_Handler;
import com.example.test_quiz.R;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashAnimation extends AwesomeSplash {

    private boolean isAdmin = false;

    @Override
    public void initSplash(ConfigSplash configSplash) {

        isAdmin = getIntent().getBooleanExtra("ChatAdmin", false);
        configSplash.setBackgroundColor(R.color.colorPrimary);
        configSplash.setAnimCircularRevealDuration(300); // int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  // or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); // or Flags.REVEAL_TOP

        // LOGO OR PATH; if String value for path not provided, it's logo by default

        //Customize Logo
        configSplash.setLogoSplash(0); // or any other drawable
        configSplash.setAnimLogoSplashDuration(0); // int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.Bounce); // chose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


        //Customize Path
//        configSplash.setPathSplash(Constants.DROID_LOGO); //set path String
        configSplash.setOriginalHeight(400); // in relation with svg (path) resource
        configSplash.setOriginalWidth(400); // in relation with svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(0);
        configSplash.setPathSplashStrokeSize(3); // Value should be < 5
        configSplash.setPathSplashStrokeColor(R.color.btn_logout_bg);
        configSplash.setAnimPathFillingDuration(500);
        configSplash.setPathSplashFillColor(R.color.strokeColor); // path object filling color


        //Customize Title
        configSplash.setTitleSplash("");
        configSplash.setTitleTextColor(R.color.btn_logout_bg);
        configSplash.setTitleTextSize(30f); // float value
        configSplash.setAnimTitleDuration(0);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
//        configSplash.setTitleFont("fonts/.ttf"); // provide string to font located in assets/fonts/


    }

    @Override
    public void animationsFinished() {

        Intent intent = new Intent(SplashAnimation.this, Chat_Handler.class);
        intent.putExtra("ChatAdmin", isAdmin);
        startActivity(intent);
        finish();
    }
}
