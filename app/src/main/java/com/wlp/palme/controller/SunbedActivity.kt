package com.wlp.palme.controller

import android.app.AlertDialog
import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.GridLayoutManager
import com.wlp.palme.R
import com.wlp.palme.adapter.RowsAdapter
import com.wlp.palme.domain.DataDomain
import com.wlp.palme.util.BROADCAST_RESERVATION
import kotlinx.android.synthetic.main.activity_sunbed.*

class SunbedActivity : AppCompatActivity() {


    lateinit var recycleAdapter: RowsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sunbed)


        val sector: String = intent.getStringExtra("SECTOR")

        recycleAdapter = RowsAdapter(this, DataDomain.sector(sector)!!)

        sunbedListView.adapter = recycleAdapter

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