package com.wlp.palme.controller.handler

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import com.wlp.palme.MainActivity

class SplashHandler(val context: Context, val activity: Activity) : Handler()
{


    override fun handleMessage(msg: Message) {

        var localIntent : Intent? = null;

        super.handleMessage(msg)

        when(msg.what){
            0->  localIntent = Intent(context, MainActivity::class.java)
        }

        context.startActivity(localIntent!!)
        activity.finish()

    }
}