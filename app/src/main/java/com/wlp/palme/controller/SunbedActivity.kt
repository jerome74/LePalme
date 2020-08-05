package com.wlp.palme.controller

import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.GridLayoutManager
import com.wlp.palme.R
import com.wlp.palme.adapter.RowsAdapterBeach
import com.wlp.palme.domain.DataDomain
import com.wlp.palme.util.*
import kotlinx.android.synthetic.main.activity_sunbed.*

class SunbedActivity : AppCompatActivity() {


    lateinit var recycleAdapterBeach: RowsAdapterBeach

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sunbed)


        val sector: String = intent.getStringExtra("SECTOR")

        if(sector == ROW_BOTTON_SX || sector == ROW_BOTTON_DX ){
            recycleAdapterBeach = RowsAdapterBeach(this, DataDomain.sector(sector)!!)
            sunbedListView.adapter = recycleAdapterBeach
        }



        if(sector == ROW_TOP_DX){
            recycleAdapterBeach = RowsAdapterBeach(this, DataDomain.sector(sector)!!)
            sunbedListView.adapter = recycleAdapterBeach
        }



        val linearLayout: GridLayoutManager = GridLayoutManager(this, 1)
        sunbedListView.layoutManager = linearLayout

        sunbedListView.setHasFixedSize(true)

        LocalBroadcastManager.getInstance(this).registerReceiver(
            reservationReceiver, IntentFilter(
                BROADCAST_RESERVATION
            )
        )

    }

    /**
     * onAddReservation
     */

    fun onAddReservation(view: View) {

    }

    /**
     *  reservationReceiver
     */


    val reservationReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

        }
    }
}