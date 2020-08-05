package com.wlp.palme

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.wlp.palme.controller.SunbedActivity
import com.wlp.palme.controller.SunbedActivityGreenDx
import com.wlp.palme.controller.SunbedActivityGreenSx
import com.wlp.palme.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onClick_img_sector_botton_dx(view : View){
        val localIntent : Intent = Intent(this,SunbedActivity::class.java)
        localIntent.putExtra("SECTOR", ROW_BOTTON_DX)
        startActivity(localIntent)
    }

    fun onClick_img_sector_botton_sx(view : View){

        val localIntent : Intent = Intent(this,SunbedActivity::class.java)
        localIntent.putExtra("SECTOR", ROW_BOTTON_SX)
        startActivity(localIntent)

    }

    fun onClick_img_sector_top_sx(view : View){
        val localIntent : Intent = Intent(this,SunbedActivityGreenSx::class.java)
        localIntent.putExtra("SECTOR", ROW_TOP_SX)
        startActivity(localIntent)
    }

    fun onClick_img_sector_top_dx(view : View){
        val localIntent : Intent = Intent(this,SunbedActivityGreenDx::class.java)
        localIntent.putExtra("SECTOR", ROW_TOP_DX)
        startActivity(localIntent)
    }

}