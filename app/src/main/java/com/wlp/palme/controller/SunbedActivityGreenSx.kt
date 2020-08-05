package com.wlp.palme.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.wlp.palme.R
import com.wlp.palme.adapter.RowsAdapterBeach
import com.wlp.palme.adapter.RowsAdapterMeadowSX
import com.wlp.palme.domain.DataDomain
import com.wlp.palme.util.ROW_TOP_SX
import kotlinx.android.synthetic.main.activity_sunbed.*

class SunbedActivityGreenSx : AppCompatActivity() {

    lateinit var recycleAdapterMeadowSX: RowsAdapterMeadowSX

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sunbed_green_sx)

        val sector: String = intent.getStringExtra("SECTOR")

        if(sector == ROW_TOP_SX){
            recycleAdapterMeadowSX = RowsAdapterMeadowSX(this, DataDomain.sector(sector)!!)
            sunbedListView.adapter = recycleAdapterMeadowSX
        }

        val linearLayout: GridLayoutManager = GridLayoutManager(this, 1)
        sunbedListView.layoutManager = linearLayout
    }
}