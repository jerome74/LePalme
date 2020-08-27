package com.wlp.palme.adapter

import android.app.AlertDialog
import android.content.*
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import com.wlp.palme.R
import com.wlp.palme.domain.DataDomain
import com.wlp.palme.model.Reservation
import com.wlp.palme.model.Row
import com.wlp.palme.service.LocationsService
import com.wlp.palme.util.BROADCAST_RESERVATION_OK_1
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class ReservationAdaper(val context : Context, val reservations : List<Reservation>) :  RecyclerView.Adapter<ReservationAdaper.Holder>() {

    inner class Holder (itemView: View?) : RecyclerView.ViewHolder(itemView!!)
    {

        val layoutInflater = context.getSystemService( Context.LAYOUT_INFLATER_SERVICE ) as LayoutInflater

        fun bindProduct(reservation: Reservation, context: Context)
        {
            val tv_value_number     = itemView?.findViewById<TextView>(R.id.tv_value_number)
            val tv_value_name       = itemView?.findViewById<TextView>(R.id.tv_value_name)
            val tv_value_surname    = itemView?.findViewById<TextView>(R.id.tv_value_surname)
            val tv_value_phone  = itemView?.findViewById<TextView>(R.id.tv_value_phone)
            val tv_value_date  = itemView?.findViewById<TextView>(R.id.tv_value_date)

            tv_value_number?.text   = reservation.number
            tv_value_name?.text     = reservation.firstname
            tv_value_surname?.text  = reservation.surname
            tv_value_phone?.text    = reservation.phone
            tv_value_date?.text    = reservation.datetime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reservation_list_item ,parent,false)


        val reservationReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {}}

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return reservations.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindProduct(reservations[position], context)
        val item = reservations[position]
    }
}