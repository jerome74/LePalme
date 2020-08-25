package com.wlp.palme.model

import org.json.JSONObject

class Location(var number  : String = "",
               var image : String = "",
               var rowname : String = "",
               var locationname : String = "",
               var reserved: Int = 0,
               var firstname : String = "",
               var surname : String = "",
               var phone : String = "",
               var datetime : String = "")  : IModel {

    fun reset()
    {
        image = "sunbed_free"
        rowname = ""
        locationname = ""
        reserved = 0
        firstname = ""
        surname = ""
        phone = ""
        datetime = ""
    }

    override fun toRequest(): String {
        return toString()
    }

    override fun toString(): String {

        val jsonObject: JSONObject = JSONObject();


        jsonObject.put("number", number)
        jsonObject.put("rowname", rowname)
        jsonObject.put("locationname", locationname)
        jsonObject.put("image", image)
        jsonObject.put("reserved", reserved)
        jsonObject.put("firstname", firstname)
        jsonObject.put("surname", surname)
        jsonObject.put("phone", phone)
        jsonObject.put("datetime", datetime)

        return jsonObject.toString()

    }
}