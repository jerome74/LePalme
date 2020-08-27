package com.wlp.palme.controller

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.navigation.NavigationView
import com.wlp.palme.R
import com.wlp.palme.adapter.ReservationAdaper
import com.wlp.palme.adapter.RowsAdapterBeach
import com.wlp.palme.domain.AuthObj
import com.wlp.palme.model.*
import com.wlp.palme.service.ResevationService
import com.wlp.palme.util.BROADCAST_LOGIN
import com.wlp.palme.util.BROADCAST_RESERVATION_FOUND
import kotlinx.android.synthetic.main.activity_reservation.*
import kotlinx.android.synthetic.main.activity_sunbed.*
import kotlinx.android.synthetic.main.nav_header_main.*
import org.json.JSONArray

class ReservationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)
        manageSpinner(true, View.INVISIBLE)
    }

    fun onReserBtnClicked(view : View){

        var reservation = Reservation(nameFindTxt.text.toString(), surnanameFindTxt.text.toString(),phoneFindTxt.text.toString())
        manageSpinner(false, View.VISIBLE)
        hideKeyboard()
        callReservation(reservation)

        LocalBroadcastManager.getInstance(this).registerReceiver(
            reservationReceiver, IntentFilter(
                BROADCAST_RESERVATION_FOUND
            )
        )
    }

    lateinit var adapterReservation: ReservationAdaper
    val reservations = mutableListOf<Reservation>()




    fun callReservation(reservation : Reservation)
    {
        ResevationService.findReservation(this
            ,reservation,
            {
                    esito: Boolean, messaggio: String ->
                if(esito)
                {
                    try{
                        if(messaggio.length > 0 && !messaggio.equals("[]")) {
                            val responseJson: JSONArray = JSONArray(messaggio)
                            reservations.clear()

                            var i = 0
                            while (i < responseJson.length()) {
                               val reservation = Reservation(responseJson.getJSONObject(i).getString("firstname")
                                ,responseJson.getJSONObject(i).getString("surname")
                                ,responseJson.getJSONObject(i).getString("phone")
                                ,responseJson.getJSONObject(i).getString("number")
                                   ,responseJson.getJSONObject(i).getString("datetime"))

                                reservations.add(reservation)

                                i++
                            }

                            LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(
                                BROADCAST_RESERVATION_FOUND))

                            manageSpinner(true, View.INVISIBLE)
                            LocalBroadcastManager.getInstance(this)
                                .sendBroadcast(Intent(BROADCAST_LOGIN))
                        }
                        else{
                            manageSpinner(true, View.INVISIBLE)
                            Toast.makeText(this, "nessuna prenotazione trovata!", Toast.LENGTH_SHORT).show()
                        }

                    }catch(e : Exception){
                        Toast.makeText(this, "error : ${e.message}", Toast.LENGTH_SHORT).show()
                        manageSpinner(true, View.INVISIBLE)
                    }

                }
                else
                {
                    Toast.makeText(this, "profile found error : $messaggio", Toast.LENGTH_SHORT).show()
                    manageSpinner(true, View.INVISIBLE)
                    finish()
                }

                CompleteObj.esitoLoginUser = esito
            })
    }

    fun manageSpinner(enable: Boolean, visibility : Int)
    {
        FindReservBar.visibility = visibility;

        nameFindTxt.isEnabled    = enable
        surnanameFindTxt.isEnabled   = enable
        phoneFindTxt.isEnabled = enable
    }

    fun hideKeyboard(){
        val inputManager : InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        if(inputManager.isAcceptingText)
            inputManager.hideSoftInputFromWindow(currentFocus?.windowToken,0)
    }

    val reservationReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?)
        {
            adapterReservation = ReservationAdaper(context!!, reservations)
            reservationView.adapter = adapterReservation

            val linearLayout: GridLayoutManager = GridLayoutManager(context, 1)
            reservationView.layoutManager = linearLayout
        }
    }



}