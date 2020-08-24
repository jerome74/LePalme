package com.wlp.palme.service

import android.content.Context
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.wlp.palme.domain.AuthObj
import com.wlp.palme.model.BaseStringQueryRequest
import com.wlp.palme.model.User
import com.wlp.palme.util.URI_FIND_BY_EMAIL

object EmailService {


    fun findProfileByEmail(context: Context, user : User, complete : (Boolean, String) -> Unit ){

        var uri : String = "${URI_FIND_BY_EMAIL}/${user.username}"

        var mapHeader : MutableMap<String,String> = mutableMapOf();
        mapHeader.put("Authentication","${AuthObj.token}")

        val baseStringRequest : BaseStringQueryRequest = BaseStringQueryRequest(
            uri
            ,user
            , "application/json; charset=utf-8"
            , Response.Listener<String> {
                    response -> complete(true, response)}
            , Response.ErrorListener { error -> complete(false, error.message!!) } , mapHeader, null )

        Volley.newRequestQueue(context).add(baseStringRequest)

    }



}