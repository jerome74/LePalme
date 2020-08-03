package com.wlp.palme.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.wlp.palme.R
import com.wlp.palme.adapter.RowsAdapter
import com.wlp.palme.domain.DataDomain
import kotlinx.android.synthetic.main.activity_sunbed.*

class SunbedActivity : AppCompatActivity() {


    lateinit var recycleAdapter : RowsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sunbed)


        val sector : String = intent.getStringExtra("SECTOR")

        recycleAdapter = RowsAdapter(this,DataDomain.sector(sector)!!)

        sunbedListView.adapter = recycleAdapter

        val linearLayout : GridLayoutManager = GridLayoutManager(this,1)
        sunbedListView.layoutManager = linearLayout

        sunbedListView.setHasFixedSize(true)

    }
}