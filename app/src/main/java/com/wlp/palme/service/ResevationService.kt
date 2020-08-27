package com.wlp.palme.service

import android.content.Context
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.wlp.palme.domain.AuthObj
import com.wlp.palme.model.BaseStringPostRequest
import com.wlp.palme.model.Location
import com.wlp.palme.model.Reservation
import com.wlp.palme.util.URI_FIND_RESARVATION
import com.wlp.palme.util.URI_INSERT_LOCATION

object ResevationService {

    fun findReservation(context: Context, reservation: Reservation, complete : (Boolean, String) -> Unit ){

        var uri : String = "$URI_FIND_RESARVATION"

        var mapHeader : MutableMap<String,String> = mutableMapOf();
        mapHeader.put("Authentication","${AuthObj.token}")

        val baseStringRequest : BaseStringPostRequest = BaseStringPostRequest(
            uri
            ,reservation
            , "application/json; charset=utf-8"
            , Response.Listener<String> {
                    response -> complete(true, response)}
            , Response.ErrorListener { error -> complete(false, error.message!!) } , mapHeader)

        Volley.newRequestQueue(context).add(baseStringRequest)
    }
}