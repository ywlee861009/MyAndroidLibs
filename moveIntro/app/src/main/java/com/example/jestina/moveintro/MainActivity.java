package com.example.jestina.moveintro;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class MainActivity extends AppCompatActivity {

    private ImageView mImvImage;
    private ImageView mImvLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mImvImage = (ImageView) findViewById(R.id.main_imv_images);
        mImvLogo = (ImageView) findViewById(R.id.main_imv_logo);

        setImage();
        setLogo();

    }

    private void setLogo() {
        int logoId = getLogoResource();

        Glide.with(this).
                load(logoId).
                into(mImvLogo);
    }

    private void setImage() {
        int imageId = getImageResource();

        Glide.with(this).
                load(imageId).
                animate(R.anim.left_to_right).
                listener(new RequestListener<Integer, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, Integer integer, Target<GlideDrawable> target, boolean b) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable glideDrawable, Integer integer, Target<GlideDrawable> target, boolean b, boolean b1) {
                        YWLog.d("Imageview Size = " + mImvImage.getWidth() + "/" + mImvImage.getHeight());
//
//                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 1000.0f, 0.0f, 0.0f);
//                        translateAnimation.setDuration(5000);
//
//                        mImvImage.setAnimation(translateAnimation);
                        return false;
                    }
                }).
                into(mImvImage);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        // image view size
        YWLog.d("logoview Size = " + mImvLogo.getWidth() + "/" + mImvLogo.getHeight());
        // screen size
        getScreenSize();

    }

    public int getImageResource() {
        int imageResource = 0;

        String imageName = "img_" + String.valueOf((int) (Math.random() * 5) + 1);

        imageResource = getResources().getIdentifier(imageName, "drawable", getPackageName());

        return imageResource;
    }

    public int getLogoResource() {
        int logoResource = 0;

        String logoName = "logo_" + String.valueOf((int) (Math.random() * 5) + 1);

        logoResource = getResources().getIdentifier(logoName, "drawable", getPackageName());

        return logoResource;
    }

    public void getScreenSize() {
        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
        YWLog.d("Screen size = "  + dm.widthPixels + "/" + dm.heightPixels);
    }
}