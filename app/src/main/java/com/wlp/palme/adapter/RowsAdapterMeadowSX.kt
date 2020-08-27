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
import com.wlp.palme.domain.AuthObj
import com.wlp.palme.domain.DataDomain
import com.wlp.palme.model.Row
import com.wlp.palme.service.LocationsService
import com.wlp.palme.util.BROADCAST_COUNTER
import com.wlp.palme.util.BROADCAST_RESERVATION_OK_1
import org.json.JSONObject


class RowsAdapterMeadowSX (val context : Context, val rows : List<Row>, val localdate : String) :  RecyclerView.Adapter<RowsAdapterMeadowSX.Holder>() {

    inner class Holder (itemView: View?) : RecyclerView.ViewHolder(itemView!!)
    {

        val layoutInflater = context.getSystemService( Context.LAYOUT_INFLATER_SERVICE ) as LayoutInflater

        fun bindProduct(row: Row, context: Context)
        {
            val tv_1_gr_sx = itemView?.findViewById<TextView>(R.id.tv_1_gr_sx)
            val tv_2_gr_sx = itemView?.findViewById<TextView>(R.id.tv_2_gr_sx)
            val tv_3_gr_sx = itemView?.findViewById<TextView>(R.id.tv_3_gr_sx)
            val tv_4_gr_sx = itemView?.findViewById<TextView>(R.id.tv_4_gr_sx)



            val img_sb_1_gr_sx = itemView?.findViewById<ImageView>(R.id.img_sb_1_gr_sx)
            val img_sb_2_gr_sx = itemView?.findViewById<ImageView>(R.id.img_sb_2_gr_sx)
            val img_sb_3_gr_sx = itemView?.findViewById<ImageView>(R.id.img_sb_3_gr_sx)
            val img_sb_4_gr_sx = itemView?.findViewById<ImageView>(R.id.img_sb_4_gr_sx)

            tv_1_gr_sx?.text = row.locations[0].number.toString()
            tv_2_gr_sx?.text = row.locations[1].number.toString()
            tv_3_gr_sx?.text = row.locations[2].number.toString()
            tv_4_gr_sx?.text = row.locations[3].number.toString()

            setEventClick(img_sb_1_gr_sx,row,layoutInflater,0, localdate)
            setEventClick(img_sb_2_gr_sx,row,layoutInflater,1, localdate)
            setEventClick(img_sb_3_gr_sx,row,layoutInflater,2, localdate)
            setEventClick(img_sb_4_gr_sx,row,layoutInflater,3, localdate)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sunbed_list_green_sx_item ,parent,false)


        val reservationReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {}}

        LocalBroadcastManager.getInstance(context).registerReceiver(reservationReceiver, IntentFilter(
            BROADCAST_RESERVATION_OK_1
        )
        )



        return Holder(view)
    }

    override fun getItemCount(): Int {
        return rows.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindProduct(rows[position], context)
        val item = rows[position]
    }

    /**
     *
     * setEventClick
     *
     */

    fun setEventClick(img : ImageView, row : Row, layoutInflater : LayoutInflater, index : Int, localdate : String)
    {
        img?.setOnClickListener({

            if(row.locations[index].reserved == 1)
            {
                val builder = AlertDialog.Builder(context)
                val dialogView = layoutInflater.inflate(R.layout.add_reservation_dialog, null)

                dialogView.findViewById<TextView>(R.id.addNameTxt).text = row.locations[index].firstname
                dialogView.findViewById<TextView>(R.id.addSurnameTxt).text = row.locations[index].surname
                dialogView.findViewById<TextView>(R.id.addNumberTxt).text = row.locations[index].phone

                builder.setView(dialogView)

                    .setPositiveButton("modifica", { dialog: DialogInterface?, which: Int ->

                        row.locations[index].firstname = dialogView.findViewById<TextView>(R.id.addNameTxt).text.toString()
                        row.locations[index].surname = dialogView.findViewById<TextView>(R.id.addSurnameTxt).text.toString()
                        row.locations[index].phone = dialogView.findViewById<TextView>(R.id.addNumberTxt).text.toString()


                        val bitmap = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))
                        val rounded = RoundedBitmapDrawableFactory.create(context.resources,bitmap);

                        rounded.cornerRadius = 15f;
                        rounded.isCircular = true;

                        img.setImageDrawable(rounded);

                        LocationsService.updateLocation(context!!
                            ,row.locations[index]
                        ) { esito: Boolean, messaggio: String ->
                            if(esito) {
                                try{
                                    sendWhatsAppMessage(row.locations[index].datetime
                                        , row.locations[index].firstname
                                        , row.locations[index].surname
                                        , row.locations[index].number
                                        , row.locations[index].phone, "modificata" )

                                    Toast.makeText(context, "prenotazione modificata!", Toast.LENGTH_SHORT).show()

                                }catch(e : Exception){
                                    Toast.makeText(context, "error : ${e.message}", Toast.LENGTH_SHORT).show()
                                }

                            } else {
                                Toast.makeText(context!!, "errore modifica prenotazione : $messaggio", Toast.LENGTH_SHORT).show()
                            }
                        }

                    })
                    .setNegativeButton("cancella", {
                            dialog: DialogInterface?, which: Int ->

                    })
                    .setNeutralButton("annulla prenotazione", {
                            dialog: DialogInterface?, which: Int ->

                        LocationsService.deleteLocationsById(context!!
                            ,row.locations[index]
                        ) { esito: Boolean, messaggio: String ->
                            if(esito) {
                                try{
                                    sendWhatsAppMessage(row.locations[index].datetime
                                        , row.locations[index].firstname
                                        , row.locations[index].surname
                                        , row.locations[index].number
                                        , row.locations[index].phone, "annullata" )

                                    Toast.makeText(context, "prenotazione annullata!", Toast.LENGTH_SHORT).show()

                                    row.locations[index].reset()

                                    dialogView.findViewById<TextView>(R.id.addNameTxt).text = row.locations[index].firstname
                                    dialogView.findViewById<TextView>(R.id.addSurnameTxt).text = row.locations[index].surname
                                    dialogView.findViewById<TextView>(R.id.addNumberTxt).text = row.locations[index].phone

                                    val bitmap = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier(row.locations[index].image, "mipmap", context.packageName))
                                    val rounded = RoundedBitmapDrawableFactory.create(context.resources,bitmap);

                                    rounded.cornerRadius = 15f;
                                    rounded.isCircular = true;

                                    img.setImageDrawable(rounded);


                                }catch(e : Exception){
                                    Toast.makeText(context, "error : ${e.message}", Toast.LENGTH_SHORT).show()
                                }

                            } else {
                                Toast.makeText(context!!, "errore annullamento prenotazione : $messaggio", Toast.LENGTH_SHORT).show()
                            }
                        }
                    })
                    .create().show()

            }else{

                val builder = AlertDialog.Builder(context)
                val dialogView = layoutInflater.inflate(R.layout.add_reservation_dialog, null)

                builder.setView(dialogView)

                    .setPositiveButton("Inserisci", { dialog: DialogInterface?, which: Int ->

                        val addNameTxt = dialogView.findViewById<TextView>(R.id.addNameTxt)
                        val addSurnameTxt = dialogView.findViewById<TextView>(R.id.addSurnameTxt)
                        val addNumberTxt = dialogView.findViewById<TextView>(R.id.addNumberTxt)

                        row.locations[index].image = "sunbed_out"
                        row.locations[index].reserved = 1
                        row.locations[index].firstname = addNameTxt.text.toString()
                        row.locations[index].surname = addSurnameTxt.text.toString()
                        row.locations[index].phone = addNumberTxt.text.toString()
                        row.locations[index].datetime = localdate

                        LocationsService.insertLocation(context!!
                            ,row.locations[index]
                        ) { esito: Boolean, messaggio: String ->
                            if(esito) {
                                try{
                                    sendWhatsAppMessage(row.locations[index].datetime
                                        , row.locations[index].firstname
                                        , row.locations[index].surname
                                        , row.locations[index].number
                                        , row.locations[index].phone, "inserita" )

                                    Toast.makeText(context, "prenotazione inserita!", Toast.LENGTH_SHORT).show()

                                    val responseJson : JSONObject = JSONObject(messaggio)
                                    row.locations[index].id = responseJson.getString("id").toInt()

                                }catch(e : Exception){
                                    Toast.makeText(context, "error : ${e.message}", Toast.LENGTH_SHORT).show()
                                }

                            } else {
                                Toast.makeText(context!!, "errore iserimento prenotazione : $messaggio", Toast.LENGTH_SHORT).show()
                            }
                        }


                        val bitmap = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))
                        val rounded = RoundedBitmapDrawableFactory.create(context.resources,bitmap);

                        rounded.cornerRadius = 15f;
                        rounded.isCircular = true;

                        img.setImageDrawable(rounded);

                    })
                    .setNegativeButton("cancella", {
                            dialog: DialogInterface?, which: Int ->

                    }).create().show()}
        })

        val bitmap = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier(row.locations[index].image, "mipmap", context.packageName))
        val rounded = RoundedBitmapDrawableFactory.create(context.resources,bitmap);

        rounded.cornerRadius = 15f;
        rounded.isCircular = true;

        img.setImageDrawable(rounded);
    }

    fun sendWhatsAppMessage(datetime : String , fistname : String, surname : String, number : String, phone : String , action : String ){

        if(AuthObj.notify.equals("true")) {

            try {
                val text: String =
                    "salve, la sua prenotazione dell'ombrellone numero : $number, al nome : $fistname $surname, " +
                            "per il giorno :  ${datetime.substring(0, 2)}/${datetime.substring(
                                2,
                                4
                            )}/${datetime.substring(4, 8)}  è stata $action!"
                var number: String = "39$phone"

                val sendIntent = Intent("android.intent.action.MAIN")
                sendIntent.putExtra("jid", number.toString() + "@s.whatsapp.net")
                sendIntent.putExtra(Intent.EXTRA_TEXT, text)
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                sendIntent.setPackage("com.whatsapp")
                sendIntent.type = "text/plain"
                context.startActivity(sendIntent)
            } catch (e: Exception) {
                println(e.printStackTrace())
            }
        }

        when(action)
        {
            "inserita" -> DataDomain.number_free_row_top_sx--
            "annullata" -> DataDomain.number_free_row_top_sx++
        }

        LocalBroadcastManager.getInstance(context).sendBroadcast(Intent(BROADCAST_COUNTER))
    }

}