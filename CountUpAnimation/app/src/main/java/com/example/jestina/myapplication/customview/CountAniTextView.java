package com.example.jestina.myapplication.customview;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;

import com.example.jestina.myapplication.utils.Utils;
import com.example.jestina.myapplication.utils.YWLog;

import java.util.Locale;

/**
 * Created by JESTINA on 2018-08-24.
 *
 * TextView 의 변화를 애니메이션 처럼 보여주는 TextView
 * setText() 에는 숫자만 입력이 가능함.
 *
 *
 */

public class CountAniTextView extends android.support.v7.widget.AppCompatTextView {
    //  기본 애니메이션 재생 시간 (밀리초 단위)
    private int ANIMATION_TIME = 5 * 1000;

    //  애니메이션 후, 숫자를 어떤 포멧으로 보여줄건지 결정
    //  0 : plain
    //  1 : 천자리마다 콤마 추가
    private int DISPLAY_TYPE = 0;

    public static final int DISPLAY_TYPE_NORMAL = 0;
    public static final int DISPLAY_TYPE_WITH_COMMA = 1;

    public CountAniTextView(Context context) {
        super(context);
    }

    public CountAniTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountAniTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     *
     * @param text
     * @throws Exception
     */
    public void setText(String text) throws Exception {
        //  콤마 제거
        text = text.replaceAll(",", "");

        //  숫자가 아니면 Exception 던짐
        if(!Utils.checkNumber(text))
            throw new Exception("NotNumberException");

        int startValue = 0;
        int endValue = 0;


        try {
            startValue = Integer.parseInt(this.getText().toString().replaceAll(",", ""));
            endValue = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            // Do nothing..
            YWLog.d("in Exception : " + e.toString());
        }

        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(startValue, endValue);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                CountAniTextView.this.setTextWithType(String.valueOf(animation.getAnimatedValue()));
            }
        });
        animator.setEvaluator(new TypeEvaluator<Integer>() {
            @Override
            public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                YWLog.d("evaluate() : " + (startValue + (endValue - startValue) * fraction) + "/startValue=" + startValue + "/endValue=" + endValue + "/fraction=" + fraction);
                return Math.round(startValue + (endValue - startValue) * fraction);
            }
        });
        animator.setDuration(ANIMATION_TIME);
        animator.start();
    }

    /**
     *
     */
    public void setTextWithType(String cs) {
        String finalString;

        if(this.DISPLAY_TYPE == DISPLAY_TYPE_WITH_COMMA)
            finalString = String.format(Locale.KOREA,"%,d", Integer.parseInt(cs));
        else
            finalString = cs;

        super.setText(finalString);
    }

    /**
     * 애니메이션 재생 시간 설정 함수
     *
     * @param milisec 애니메이션 재생 시간 (milisec)
     */
    public void setAnimationTime(int milisec) {
        this.ANIMATION_TIME = milisec;
    }

    /**
     * 애니메이션 후 textview 에 display 를 어떻게 할 것인지 묻는 함수
     *
     * @param type 0 : 있는 그대로
     *             1 : 천단위 콤마 표시
     */
    public void setDiaplayType(int type) {this.DISPLAY_TYPE = type;}
}
