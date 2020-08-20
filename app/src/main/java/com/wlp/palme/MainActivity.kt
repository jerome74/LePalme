package com.wlp.palme

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.wlp.palme.controller.LoginActivity
import com.wlp.palme.controller.SunbedActivity
import com.wlp.palme.controller.SunbedActivityGreenDx
import com.wlp.palme.controller.SunbedActivityGreenSx
import com.wlp.palme.domain.AuthObj
import com.wlp.palme.model.UserObj
import com.wlp.palme.util.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LocalBroadcastManager.getInstance(this).registerReceiver(loginReceiver, IntentFilter(
            BROADCAST_LOGIN))
    }

    fun onClick_img_sector_botton_dx(view : View){

        if (!AuthObj.isLoggIn) {

            Toast.makeText(this, "eseguire il Login!", Toast.LENGTH_SHORT).show()

        }else {

            val localIntent: Intent = Intent(this, SunbedActivity::class.java)
            localIntent.putExtra("SECTOR", ROW_BOTTON_DX)
            startActivity(localIntent)
        }
    }

    fun onClick_img_sector_botton_sx(view : View){

        if (!AuthObj.isLoggIn) {

            Toast.makeText(this, "eseguire il Login!", Toast.LENGTH_SHORT).show()

        }else {

            val localIntent: Intent = Intent(this, SunbedActivity::class.java)
            localIntent.putExtra("SECTOR", ROW_BOTTON_SX)
            startActivity(localIntent)
        }

    }

    fun onClick_img_sector_top_sx(view : View){

        if (!AuthObj.isLoggIn) {

            Toast.makeText(this, "eseguire il Login!", Toast.LENGTH_SHORT).show()

        }else {

            val localIntent: Intent = Intent(this, SunbedActivityGreenSx::class.java)
            localIntent.putExtra("SECTOR", ROW_TOP_SX)
            startActivity(localIntent)
        }
    }

    fun onClick_img_sector_top_dx(view : View){

        if (!AuthObj.isLoggIn) {

            Toast.makeText(this, "eseguire il Login!", Toast.LENGTH_SHORT).show()

        }else {

            val localIntent: Intent = Intent(this, SunbedActivityGreenDx::class.java)
            localIntent.putExtra("SECTOR", ROW_TOP_DX)
            startActivity(localIntent)
        }
    }

    fun onLoginBntClicked(view : View){

        if (!AuthObj.isLoggIn) {
            val intentLogin : Intent = Intent(this, LoginActivity::class.java)
            startActivity(intentLogin)
        }
        else
        {
            loginBtn.text = "Log-In"

            UserObj.reset()
            AuthObj.reset()
        }

    }

    val loginReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?)
        {
            if (AuthObj.isLoggIn)
            {
                emailTxt.text = UserObj.userProfile?.email
                loginBtn.text = "Log-out"

                val identifier = resources.getIdentifier(UserObj.userProfile?.avatarName,"drawable",packageName)

                userImg.setImageResource(identifier)

            }
        }
    }

}