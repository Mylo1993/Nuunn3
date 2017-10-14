package com.peninsula.nuunn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ImageView floater;
        ImageView floater2;
        ImageButton alphas;
        Animation animFloat;
        Animation animFloat2;
        Animation animAlpha;
        Animation animAlphaOut;
        floater = (ImageView) findViewById(R.id.ghost);
        floater2 = (ImageView) findViewById(R.id.talsman);
        alphas = (ImageButton)findViewById(R.id.startGame);
        animFloat = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.floata);
        animFloat2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.floata2);
        animAlpha = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.alpha);
        animAlphaOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.alphaout);
        floater.startAnimation(animFloat);
        floater2.startAnimation(animFloat2);
        alphas.startAnimation(animAlpha);
        ImageButton btn = (ImageButton) findViewById(R.id.startGame);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(v.getContext(), StoryScreen.class);
                startActivity(myIntent);
                overridePendingTransition(R.anim.alpha, R.anim.alphaout);
            }
        });


    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}