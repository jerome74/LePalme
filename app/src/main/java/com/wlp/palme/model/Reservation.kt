package com.wlp.palme.model

import org.json.JSONObject

data class Reservation constructor(var firstname: String, var surname : String, var phone : String, var number : String = "", var datetime : String = "") : IModel
{
    override fun toRequest() : String {
        return toString()
    }

    override fun toString(): String {

        val jsonObject : JSONObject = JSONObject();

        jsonObject.put("firstname", firstname)
        jsonObject.put("surname", surname)
        jsonObject.put("phone", phone)

        return jsonObject.toString()

    }
}