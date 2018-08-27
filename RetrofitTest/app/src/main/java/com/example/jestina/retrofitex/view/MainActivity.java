package com.example.jestina.retrofitex.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jestina.retrofitex.R;
import com.example.jestina.retrofitex.common.YWLog;
import com.example.jestina.retrofitex.contract.MainContract;
import com.example.jestina.retrofitex.network.APIClient;
import com.example.jestina.retrofitex.network.APIInterface;
import com.example.jestina.retrofitex.network.response.MultipleResources;
import com.example.jestina.retrofitex.presenter.MainPresenter;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    MainPresenter mPresenter;
    APIInterface apiInterface;

    private TextView mTxvRetrofitResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initPresenter();

        test();
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);

        mTxvRetrofitResponse = (TextView) findViewById(R.id.activity_main_txv_retrofit_response);
    }

    @Override
    public void initPresenter() {
        mPresenter = new MainPresenter();
        mPresenter.initPresenter(this);
    }

    public void test() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<MultipleResources> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MultipleResources>() {
            @Override
            public void onResponse(Call<MultipleResources> call, Response<MultipleResources> response) {
                YWLog.d(response.code() + "");

                String displayResponse = "";

                MultipleResources resources = response.body();
                Integer text = resources.page;
                Integer total = resources.total;
                Integer totalPages = resources.total_pages;

                List<MultipleResources.Datum> datumList = resources.data;

                displayResponse += text + "Page\n" + total + " Total\n" + totalPages + " total pages";
                for (MultipleResources.Datum datum : datumList) {
                    displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue;
                }

                mTxvRetrofitResponse.setText(displayResponse);
            }

            @Override
            public void onFailure(Call<MultipleResources> call, Throwable throwable) {
                YWLog.d(throwable.toString());
            }
        });
    }
}
