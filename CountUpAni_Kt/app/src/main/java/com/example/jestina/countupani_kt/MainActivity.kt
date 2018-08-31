package com.example.jestina.countupani_kt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.jestina.countupani_kt.utils.YWLog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        YWLog.d("adsf")
    }
}
