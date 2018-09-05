package com.example.jestina.myerp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jestina.myerp.R;
import com.example.jestina.myerp.contract.LoginContract;
import com.example.jestina.myerp.presenter.LoginPresenter;


public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private View rootView;
    private LoginPresenter mPresenter;

    private EditText mEtxID; // 사번
    private EditText mEtxPW; // 비번
    private Button mBtnLogin; // 로그인
    private TextView mTxvQuestion; // 문의하기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_login);

        mPresenter = new LoginPresenter();
        mPresenter.setContext(LoginActivity.this);

        rootView = getWindow().getDecorView().findViewById(android.R.id.content);

        mEtxID = (EditText) findViewById(R.id.etx_id);

        mEtxPW = (EditText) findViewById(R.id.etx_pw);

        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(onClickListener);

        mTxvQuestion = (TextView) findViewById(R.id.txv_question);
        mTxvQuestion.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_login:
                    goToLogin(mEtxID.getText().toString(),
                            mEtxPW.getText().toString());
                    break;

                case R.id.txv_question:
                    goToQuestion();
                    break;
            }
        }
    };

    /**
     * 로그인 하기
     *
     * @param id
     * @param pw
     */
    private void goToLogin(String id, String pw) {
        if(TextUtils.isEmpty(id)) {
            Snackbar.make(rootView, "사번을 입력해 주세요.", Snackbar.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(pw)) {
            Snackbar.make(rootView, "패스워드를 입력해 주세요.", Snackbar.LENGTH_SHORT).show();
            return;
        }

        String serverId = mPresenter.getUserInfo(LoginPresenter.USER_INFO_ID);
        String serverPw = mPresenter.getUserInfo(LoginPresenter.USER_INFO_PW);

        if(!TextUtils.equals(id, serverId)) {
            Snackbar.make(rootView, "존재하지 않는 ID 입니다.\n확인 후 다시 시도해주세요.", Snackbar.LENGTH_SHORT).show();
            return;
        }

        if(!TextUtils.equals(pw, serverPw)) {
            Snackbar.make(rootView, "패스워드가 맞지 않습니다.\n확인 후 다시 시도해주세요.", Snackbar.LENGTH_SHORT).show();
            return;
        }

        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        LoginActivity.this.finish();
    }




    /**
     * 문의하기
     */
    private void goToQuestion() {
        Snackbar.make(rootView, "준비중 입니다.", Snackbar.LENGTH_SHORT).show();
    }
}
