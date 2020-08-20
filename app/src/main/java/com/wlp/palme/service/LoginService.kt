package com.wlp.palme.service

import android.content.Context
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.wlp.palme.model.BaseStringPostRequest
import com.wlp.palme.model.User
import com.wlp.palme.util.URI_LOGIN
import java.lang.Exception

object LoginService {


    fun loginUser(context: Context, user : User, complete : (Boolean, String) -> Unit ){

        var uri : String = URI_LOGIN

        val baseStringRequest : BaseStringPostRequest = BaseStringPostRequest(
            uri
            ,user
            , "application/json; charset=utf-8"
            , Response.Listener<String> {
                    response -> complete(true, response)}
            , Response.ErrorListener { error ->
                try {
                    complete(false, error.message!!)
                }catch (e : Exception){
                    //Toast.makeText(context, "email and/or password incorrect.", Toast.LENGTH_SHORT).show()
                    complete(false, "email and/or password incorrect.")
                }
            } , null )

        Volley.newRequestQueue(context).add(baseStringRequest)

    }


}