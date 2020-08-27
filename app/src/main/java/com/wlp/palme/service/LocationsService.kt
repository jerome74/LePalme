package com.wlp.palme.service

import android.content.Context
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.wlp.palme.domain.AuthObj
import com.wlp.palme.model.*
import com.wlp.palme.util.*

object LocationsService {


    fun findLocationsByDateTime(context: Context, location: Location, complete : (Boolean, String) -> Unit ){

        var uri : String = "$URI_FIND_BY_DATETIME/${location.datetime}"

        var mapHeader : MutableMap<String,String> = mutableMapOf();
        mapHeader.put("Authentication","${AuthObj.token}")

        val baseStringRequest : BaseStringQueryRequest = BaseStringQueryRequest(
            uri
            ,location
            , "application/json; charset=utf-8"
            , Response.Listener<String> {
                    response -> complete(true, response)}
            , Response.ErrorListener { error -> complete(false, error.message!!) } , mapHeader, null )

        Volley.newRequestQueue(context).add(baseStringRequest)

    }

    fun insertLocation(context: Context, location: Location, complete : (Boolean, String) -> Unit ){

        var uri : String = "$URI_INSERT_LOCATION"

        var mapHeader : MutableMap<String,String> = mutableMapOf();
        mapHeader.put("Authentication","${AuthObj.token}")

        val baseStringRequest : BaseStringPostRequest = BaseStringPostRequest(
            uri
            ,location
            , "application/json; charset=utf-8"
            , Response.Listener<String> {
                    response -> complete(true, response)}
            , Response.ErrorListener { error -> complete(false, error.message!!) } , mapHeader)

        Volley.newRequestQueue(context).add(baseStringRequest)

    }

    fun updateLocation(context: Context, location: Location, complete : (Boolean, String) -> Unit ){

        var uri : String = "$URI_UPDATE_LOCATION/${location.id}"

        var mapHeader : MutableMap<String,String> = mutableMapOf();
        mapHeader.put("Authentication","${AuthObj.token}")

        val baseStringRequest : BaseStringPostQueryRequest = BaseStringPostQueryRequest(
            uri
            ,location
            , "application/json; charset=utf-8"
            , Response.Listener<String> {
                    response -> complete(true, response)}
            , Response.ErrorListener { error -> complete(false, error.message!!) } , mapHeader, null)

        Volley.newRequestQueue(context).add(baseStringRequest)

    }

    fun deleteLocationsById(context: Context, location: Location, complete : (Boolean, String) -> Unit ){

        var uri : String = "$URI_DELETE_LOCATION/${location.id}"

        var mapHeader : MutableMap<String,String> = mutableMapOf();
        mapHeader.put("Authentication","${AuthObj.token}")

        val baseStringRequest : BaseStringQueryRequest = BaseStringQueryRequest(
            uri
            ,location
            , "application/json; charset=utf-8"
            , Response.Listener<String> {
                    response -> complete(true, response)}
            , Response.ErrorListener { error -> complete(false, error.message!!) } , mapHeader, null )

        Volley.newRequestQueue(context).add(baseStringRequest)

    }
}