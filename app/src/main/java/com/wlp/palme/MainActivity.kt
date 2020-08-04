package com.wlp.palme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wlp.palme.adapter.RowsAdapter
import com.wlp.palme.controller.SunbedActivity
import com.wlp.palme.util.ROW_TOP_SX

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onClick_img_sector_top_sx(view : View){


    }

    fun onClick_img_sector_botton_sx(view : View){

        val localIntent : Intent = Intent(this,SunbedActivity::class.java)
        localIntent.putExtra("SECTOR", ROW_TOP_SX)
        startActivity(localIntent)

    }

}