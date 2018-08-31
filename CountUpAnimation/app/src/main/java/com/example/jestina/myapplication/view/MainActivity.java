package com.example.jestina.myapplication.view;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jestina.myapplication.R;
import com.example.jestina.myapplication.contract.MainContract;
import com.example.jestina.myapplication.customview.CountAniTextView;
import com.example.jestina.myapplication.presenter.MainPresenter;
import com.example.jestina.myapplication.utils.YWLog;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainPresenter mPresenter;

    private CountAniTextView mTxvCountUpEx; // 카운트가 애니메이션 되면서 내려가거나 올라가는것을 표현할 textview
    private EditText mEtxCount; // 어디까지 올리거나 내릴지 적어주는 edittext
    private Button mBtnCountUp; // 버튼을 누르면 etx 의 count 를 받아와 textview 를 갱신

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayout();
        initMemberPresenter();
    }

    @Override
    public void initLayout() {
        setContentView(R.layout.activity_main);

        mTxvCountUpEx = (CountAniTextView) findViewById(R.id.main_txv_count_up_ex);
        mTxvCountUpEx.setAnimationTime(1 * 300);
        mTxvCountUpEx.setDiaplayType(CountAniTextView.DISPLAY_TYPE_WITH_COMMA);

        mEtxCount = (EditText) findViewById(R.id.main_etx_count);
        mBtnCountUp = (Button) findViewById(R.id.main_btn_count_up);
        mBtnCountUp.setOnClickListener(onClickListener);
    }


    @Override
    public void initMemberPresenter() {
        mPresenter = new MainPresenter();
        mPresenter.initPresenter(this);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                mTxvCountUpEx.setText(mEtxCount.getText().toString());
            } catch (Exception e) {
                YWLog.d("Exception!!!! > " + e.toString());
            }
        }
    };
}