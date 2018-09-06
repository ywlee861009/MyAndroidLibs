package com.example.jestina.moveintro;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    private ImageView mImvImage;
    private ImageView mImvLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mImvImage = (ImageView) findViewById(R.id.main_imv_images);
        mImvLogo = (ImageView) findViewById(R.id.main_imv_logo);


    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    private void setLogo() {
        int logoId = getLogoResource();

        Glide.with(this).
                load(logoId).
                into(mImvLogo);
    }



    private void setImage() {
        int imageId = getImageResource();

        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(mImvImage);
        Glide.with(this).
//                load("http://webimg.jestina.co.kr/UpData/App//Template/201702/170222_yuna_re_1536.png").
//                load("https://raw.githubusercontent.com/ywlee861009/MyAndroidLibs/master/moveIntro/app/src/main/res/drawable/img_1.jpg").
                load("https://raw.githubusercontent.com/ywlee861009/MyAndroidLibs/master/moveIntro/app/src/main/res/drawable/img.png").
                listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String integer, Target<GlideDrawable> target, boolean b) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable glideDrawable, String integer, Target<GlideDrawable> target, boolean b, boolean b1) {

                        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
                        YWLog.d("image size = " + glideDrawable.getIntrinsicWidth() + "/" + glideDrawable.getIntrinsicHeight());
                        YWLog.d("Screen size = "  + dm.widthPixels + "/" + dm.heightPixels);

                        TranslateAnimation translateAnimation = new TranslateAnimation(
                                Animation.RELATIVE_TO_SELF, 0.0f,
                                Animation.RELATIVE_TO_SELF, -1.0f,
                                Animation.RELATIVE_TO_SELF, 0.0f,
                                Animation.RELATIVE_TO_SELF, 0.0f
                        );
                        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                YWLog.d("========> onAnimationStart() ");
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                YWLog.d("========> onAnimationEnd() ");
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        translateAnimation.setFillAfter(true);
                        translateAnimation.setDuration(3000);

                        mImvImage.setAnimation(translateAnimation);
                        mImvImage.startAnimation(translateAnimation);


                        return false;
                    }
                }).
                into(imageViewTarget);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        // image view size
        // screen size


        setImage();
        setLogo();

    }

    public int getImageResource() {
        int imageResource = 0;

        String imageName = "img_" + String.valueOf((int) (Math.random() * 5) + 1);
//        String imageName = "img";

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