package com.example.jestina.moveintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImvImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImvImage = (ImageView) findViewById(R.id.main_imv_images);

        TranslateAnimation translateAnimation = new TranslateAnimation(0f, -500f, 0f, 0f);
        translateAnimation.setDuration(5000);
        translateAnimation.setRepeatCount(5);
        translateAnimation.setRepeatMode(2);

        mImvImage.setAnimation(translateAnimation);
    }
}