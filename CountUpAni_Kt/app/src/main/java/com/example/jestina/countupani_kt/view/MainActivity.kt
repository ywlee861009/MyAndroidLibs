package com.example.jestina.countupani_kt.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.jestina.countupani_kt.R
import com.example.jestina.countupani_kt.utils.YWLog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        YWLog.d("adsf")
    }
}
