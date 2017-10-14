package com.peninsula.nuunn;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.R.attr.animation;

public class StoryScreen extends AppCompatActivity {


    static boolean active = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_story_screen);



        final ImageView floaterr;
        final ImageButton next;
        final Animation animAlpha;
        final Animation animAlphaOut;
        final ImageView building;
        final ImageView whisper;

        final ConstraintLayout con = (ConstraintLayout) findViewById(R.id.storyid);
        next = (ImageButton)findViewById(R.id.next);

         animAlpha = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.alpha);
        animAlphaOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.alphaout);
        next.postDelayed(new Runnable() {

            @Override
            public void run() {
                next.setVisibility(View.VISIBLE);
                next.startAnimation(animAlpha);
            }

        }, 11000); // 15000ms delay




        floaterr = (ImageView) findViewById(R.id.storymascot);

        Animation animFloater;
        animFloater = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.floata);
        floaterr.startAnimation(animFloater);
        final TypeWriter tw = (TypeWriter) findViewById(R.id.storyTextView);


        tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tw.isActivated()){

                }


                tw.setCharacterDelay(0);


            }





            });


        tw.postDelayed(new Runnable() {

            @Override
            public void run() {
                tw.setText("");
                tw.setCharacterDelay(2);

                tw.animateText(getResources().getString(R.string.rock1));
            }

        }, 2000); // 2000ms delay
        building = (ImageView) findViewById(R.id.building);
        whisper = (ImageView) findViewById(R.id.whisper);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(tw.getText() == getResources().getString(R.string.rock1)) {

                   tw.setText("");
                   tw.setCharacterDelay(2);
                   tw.animateText(getResources().getString(R.string.rock2));

               }
               else if(tw.getText() == getResources().getString(R.string.rock2)){
                    tw.setText("");
                    tw.setCharacterDelay(2);
                    tw.animateText(getResources().getString(R.string.rock3));

               }
               else if(tw.getText() == getResources().getString(R.string.rock3)){

                   con.setBackgroundResource(R.drawable.dark);
                   building.startAnimation(animAlphaOut);
                   building.setVisibility(View.VISIBLE);
                   building.startAnimation(animAlpha);
                    tw.startAnimation(animAlphaOut);
                   floaterr.startAnimation(animAlphaOut);
                   floaterr.setVisibility(View.INVISIBLE);



                   tw.postDelayed(new Runnable() {

                       @Override
                       public void run() {
                           tw.setText("");
                           tw.setCharacterDelay(2);

                           tw.animateText(getResources().getString(R.string.building1));
                       }

                   }, 2500); // 2000ms delay



                }
               else if(tw.getText() == getResources().getString(R.string.building1)){
                   building.setVisibility(View.INVISIBLE);
                   whisper.setVisibility(View.VISIBLE);
                   whisper.startAnimation(animAlpha);



               }


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

