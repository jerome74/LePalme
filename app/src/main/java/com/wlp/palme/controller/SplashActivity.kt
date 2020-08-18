package com.wlp.palme.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import com.wlp.palme.R
import com.wlp.palme.controller.handler.SplashHandler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashHandler = SplashHandler(this,this)
        val splashMessage = Message()

        splashMessage.what = 0

        splashHandler.sendMessageDelayed(splashMessage, 3000);

    }
}