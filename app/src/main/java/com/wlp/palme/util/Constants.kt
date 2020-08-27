package com.wlp.palme.util

const val ROW_BOTTON_SX = "#row_botton_sx#"
const val ROW_BOTTON_DX = "#row_botton_dx#"
const val ROW_TOP_SX = "#row_top_sx#"
const val ROW_TOP_DX = "#row_top_dx#"

/**
 * BROADCAST
 */

const val BROADCAST_LOGIN = "BROADCAST_9999"
const val BROADCAST_DATE = "BROADCAST_9998"
const val BROADCAST_RESERVATION = "BROADCAST_9997"
const val BROADCAST_RESERVATION_FOUND = "broadcast.reservation"
const val BROADCAST_RESERVATION_OK_1 = "broadcast.reservation.ok.1"


/**
 * URI
 */

//######################BASE_URI####################################
const val BASE_URL : String = "https://lepalme-service.herokuapp.com"
//-------------------------------------------------------------------


const val URI_LOGIN : String = "$BASE_URL/login"
const val URI_FIND_BY_EMAIL : String = "$BASE_URL/api/v1/locations/profile"
const val URI_FIND_BY_DATETIME : String = "$BASE_URL/api/v1/locations"
const val URI_INSERT_LOCATION : String = "$BASE_URL/api/v1/locations/location"
const val URI_UPDATE_LOCATION : String = "$BASE_URL/api/v1/locations"
const val URI_DELETE_LOCATION : String = "$BASE_URL/api/v1/locations/delete"
const val URI_FIND_RESARVATION : String = "$BASE_URL/api/v1/locations/reservation"

