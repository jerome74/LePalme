package com.wlp.palme.controller.handler

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.wlp.palme.LepalmeActivity
import com.wlp.palme.util.BROADCAST_LOGIN

class SplashHandler(val context: Context, val activity: Activity) : Handler()
{


    override fun handleMessage(msg: Message) {

        var localIntent : Intent? = null;

        super.handleMessage(msg)

        when(msg.what){
            0->  localIntent = Intent(context, LepalmeActivity::class.java)
            1 -> LocalBroadcastManager.getInstance(context).sendBroadcast(Intent(BROADCAST_LOGIN))
        }

        context.startActivity(localIntent!!)
        activity.finish()

    }
}