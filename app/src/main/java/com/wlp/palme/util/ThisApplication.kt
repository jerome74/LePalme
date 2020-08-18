package com.wlp.palme.util

import android.app.Application

class ThisApplication : Application()
{
    companion object{
        lateinit var shardPrefs : SharedPrefs
    }

    override fun onCreate() {
        shardPrefs = SharedPrefs(applicationContext)
        super.onCreate()

    }
}