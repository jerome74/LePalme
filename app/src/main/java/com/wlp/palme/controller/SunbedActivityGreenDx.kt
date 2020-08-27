package com.wlp.palme.controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.wlp.palme.R
import com.wlp.palme.adapter.RowsAdapterMeadowDX
import com.wlp.palme.domain.DataDomain
import com.wlp.palme.util.ROW_TOP_DX
import kotlinx.android.synthetic.main.activity_sunbed.*

class SunbedActivityGreenDx : AppCompatActivity() {

    lateinit var recycleAdapterMeadowDX: RowsAdapterMeadowDX

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sunbed_green_dx)

        val sector: String = intent.getStringExtra("SECTOR")
        val localdate: String = intent.getStringExtra("DATE")

        if(sector == ROW_TOP_DX){
            recycleAdapterMeadowDX = RowsAdapterMeadowDX(this, DataDomain.sector(sector)!!,localdate)
            sunbedListView.adapter = recycleAdapterMeadowDX
        }

        val linearLayout: GridLayoutManager = GridLayoutManager(this, 1)
        sunbedListView.layoutManager = linearLayout
    }
}