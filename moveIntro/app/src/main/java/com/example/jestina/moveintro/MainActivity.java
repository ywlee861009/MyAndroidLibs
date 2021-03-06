package com.example.jestina.moveintro;

import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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

    private final String STR_1080 = "https://raw.githubusercontent.com/ywlee861009/MyAndroidLibs/master/moveIntro/app/src/main/res/drawable/img2.jpg";
    private final String STR_1642 = "https://raw.githubusercontent.com/ywlee861009/MyAndroidLibs/master/moveIntro/app/src/main/res/drawable/img_1.jpg";
    private final String STR_640 = "https://raw.githubusercontent.com/ywlee861009/MyAndroidLibs/master/moveIntro/app/src/main/res/drawable/img.png";


    private ConstraintLayout mCloClo;
    private ImageView mImvImage;
    private ImageView mImvLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCloClo = (ConstraintLayout) findViewById(R.id.clo_const);
        mImvImage = (ImageView) findViewById(R.id.main_imv_images);
        mImvLogo = (ImageView) findViewById(R.id.main_imv_logo);


    }


    @Override
    protected void onResume() {
        super.onResume();

        int rand = (int) (Math.random() * 3) + 1;

        String url = "";
        if(rand == 1) {
            url = STR_1080;
        } else if(rand == 2) {
            url = STR_640;
        } else {
            url = STR_1642;
        }

        setImage(url);
        setLogo();
    }

    private void setLogo() {
        int logoId = getLogoResource();

        Glide.with(this).
                load(logoId).
                into(mImvLogo);
    }



    private void setImage(String url) {
        YWLog.d("setImage url() = " + url);
        int imageId = getImageResource();

        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(mImvImage);
        Glide.with(this).
                load(url).
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

                        // Drawable size 가 화면보다 작으면, imageview 를 match_parent 로, 애니메이션 x
                        // 크면, 세로 꽉채운후 비율고정, 애니메이션 o
                        if(glideDrawable.getMinimumWidth() <= dm.widthPixels) {
                            // 화면보다 작다.
                            YWLog.d("Smaller than screen ");


                            ConstraintSet set = new ConstraintSet();
                            set.clone(mCloClo);
                            set.setDimensionRatio(R.id.main_imv_images, "");
                            set.connect(mImvImage.getId(), ConstraintSet.RIGHT, mCloClo.getId(), ConstraintSet.RIGHT);
                            set.applyTo(mCloClo);
//                            mImvImage.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT, ConstraintLayout.LayoutParams.MATCH_CONSTRAINT));
                            mImvImage.setScaleType(ImageView.ScaleType.FIT_XY);

                        } else {
                            // 화면보다 크다.
                            YWLog.d("Lager than screen ");
                            TranslateAnimation translateAnimation = new TranslateAnimation(
                                    Animation.RELATIVE_TO_SELF, 0.0f,
                                    Animation.RELATIVE_TO_SELF, -0.1f,
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
                        }

                        return false;
                    }
                }).
                into(imageViewTarget);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);


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