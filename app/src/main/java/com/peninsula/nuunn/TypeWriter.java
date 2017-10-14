package com.peninsula.nuunn;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by peninsulaco on 10/10/17.
 */

public class TypeWriter extends TextView {
    class MyActivity extends Activity {




    }


    public boolean egg = false;
    private CharSequence mText;
    private int mIndex;
    private long mDelay = 150; // in ms
    public TypeWriter(Context context) {
        super(context);
    }
    public TypeWriter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if (mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };
    public void animateText(CharSequence txt) {
        mText = txt;
        mIndex = 0;
        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);




    }


    public void setCharacterDelay(long m) {
        mDelay = m;

    }

    public void setCharacterDelay1(short m) {
        mDelay = m;

    }



}


