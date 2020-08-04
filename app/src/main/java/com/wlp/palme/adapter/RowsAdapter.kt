package com.wlp.palme.adapter

import android.app.AlertDialog
import android.content.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import com.wlp.palme.R
import com.wlp.palme.model.Row
import com.wlp.palme.util.BROADCAST_RESERVATION
import com.wlp.palme.util.BROADCAST_RESERVATION_OK_1

class RowsAdapter(val context : Context, val rows : List<Row>) :  RecyclerView.Adapter<RowsAdapter.Holder>() {

    inner class Holder (itemView: View?) : RecyclerView.ViewHolder(itemView!!)
    {

        val layoutInflater = context.getSystemService( Context.LAYOUT_INFLATER_SERVICE ) as LayoutInflater

        fun bindProduct(row: Row, context: Context)
        {
            val tv_1 = itemView?.findViewById<TextView>(R.id.tv_1)
            val tv_2 = itemView?.findViewById<TextView>(R.id.tv_2)
            val tv_3 = itemView?.findViewById<TextView>(R.id.tv_3)
            val tv_4 = itemView?.findViewById<TextView>(R.id.tv_4)
            val tv_5 = itemView?.findViewById<TextView>(R.id.tv_5)


            val img_sb_1 = itemView?.findViewById<ImageView>(R.id.img_sb_1)
            val img_sb_2 = itemView?.findViewById<ImageView>(R.id.img_sb_2)
            val img_sb_3 = itemView?.findViewById<ImageView>(R.id.img_sb_3)
            val img_sb_4 = itemView?.findViewById<ImageView>(R.id.img_sb_4)
            val img_sb_5 = itemView?.findViewById<ImageView>(R.id.img_sb_5)

            tv_1?.text = row.locations[0].number.toString()
            tv_2?.text = row.locations[1].number.toString()
            tv_3?.text = row.locations[2].number.toString()
            tv_4?.text = row.locations[3].number.toString()
            tv_5?.text = row.locations[4].number.toString()

            /**
             * img_sb_1
             * @method setOnClickListener
             */


            img_sb_1?.setOnClickListener({

                if(row.locations[0].reserved == 1)
                {
                    Toast.makeText(context, "ombrellone già prenotato!", Toast.LENGTH_SHORT).show()

                }else{

                val builder = AlertDialog.Builder(context)
                val dialogView = layoutInflater.inflate(R.layout.add_reservation_dialog, null)

                builder.setView(dialogView)

                    .setPositiveButton("Inserisci", { dialog: DialogInterface?, which: Int ->

                        val addNameTxt = dialogView.findViewById<TextView>(R.id.addNameTxt)
                        val addSurnameTxt = dialogView.findViewById<TextView>(R.id.addSurnameTxt)
                        val addNumberTxt = dialogView.findViewById<TextView>(R.id.addNumberTxt)

                        row.locations[0].name = addNameTxt.text.toString()
                        row.locations[0].surname = addSurnameTxt.text.toString()
                        row.locations[0].phone = addNumberTxt.text.toString()
                        row.locations[0].reserved = 1

                        img_sb_1?.setImageResource(context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))

                    })
                    .setNegativeButton("cancella", {
                            dialog: DialogInterface?, which: Int ->

                    }).create().show()}
            })

            /**
             * img_sb_2
             * @method setOnClickListener
             */

            img_sb_2?.setOnClickListener({

                if(row.locations[1].reserved == 1)
                {
                    Toast.makeText(context, "ombrellone già prenotato!", Toast.LENGTH_SHORT).show()

                }else{

                    val builder = AlertDialog.Builder(context)
                    val dialogView = layoutInflater.inflate(R.layout.add_reservation_dialog, null)

                    builder.setView(dialogView)

                    .setPositiveButton("Inserisci", { dialog: DialogInterface?, which: Int ->

                        val addNameTxt = dialogView.findViewById<TextView>(R.id.addNameTxt)
                        val addSurnameTxt = dialogView.findViewById<TextView>(R.id.addSurnameTxt)
                        val addNumberTxt = dialogView.findViewById<TextView>(R.id.addNumberTxt)

                        row.locations[1].name = addNameTxt.text.toString()
                        row.locations[1].surname = addSurnameTxt.text.toString()
                        row.locations[1].phone = addNumberTxt.text.toString()
                        row.locations[1].reserved = 1

                        img_sb_2?.setImageResource(context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))

                    })
                    .setNegativeButton("cancella", {
                            dialog: DialogInterface?, which: Int ->

                    }).create().show()}
            })

            /**
             * img_sb_3
             * @method setOnClickListener
             */

            img_sb_3?.setOnClickListener({

                if(row.locations[2].reserved == 1)
                {
                    Toast.makeText(context, "ombrellone già prenotato!", Toast.LENGTH_SHORT).show()

                }else{


                    val builder = AlertDialog.Builder(context)
                    val dialogView = layoutInflater.inflate(R.layout.add_reservation_dialog, null)

                    builder.setView(dialogView)

                    .setPositiveButton("Inserisci", { dialog: DialogInterface?, which: Int ->

                        val addNameTxt = dialogView.findViewById<TextView>(R.id.addNameTxt)
                        val addSurnameTxt = dialogView.findViewById<TextView>(R.id.addSurnameTxt)
                        val addNumberTxt = dialogView.findViewById<TextView>(R.id.addNumberTxt)

                        row.locations[2].name = addNameTxt.text.toString()
                        row.locations[2].surname = addSurnameTxt.text.toString()
                        row.locations[2].phone = addNumberTxt.text.toString()
                        row.locations[2].reserved = 1

                        img_sb_3?.setImageResource(context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))

                    })
                    .setNegativeButton("cancella", {
                            dialog: DialogInterface?, which: Int ->

                    }).create().show()}
            })

            /**
             * img_sb_4
             * @method setOnClickListener
             */

            img_sb_4?.setOnClickListener({


                if(row.locations[3].reserved == 1)
                {
                    Toast.makeText(context, "ombrellone già prenotato!", Toast.LENGTH_SHORT).show()

                }else{

                    val builder = AlertDialog.Builder(context)
                    val dialogView = layoutInflater.inflate(R.layout.add_reservation_dialog, null)

                    builder.setView(dialogView)

                    .setPositiveButton("Inserisci", { dialog: DialogInterface?, which: Int ->

                        val addNameTxt = dialogView.findViewById<TextView>(R.id.addNameTxt)
                        val addSurnameTxt = dialogView.findViewById<TextView>(R.id.addSurnameTxt)
                        val addNumberTxt = dialogView.findViewById<TextView>(R.id.addNumberTxt)

                        row.locations[3].name = addNameTxt.text.toString()
                        row.locations[3].surname = addSurnameTxt.text.toString()
                        row.locations[3].phone = addNumberTxt.text.toString()
                        row.locations[3].reserved = 1

                        img_sb_4?.setImageResource(context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))

                    })
                    .setNegativeButton("cancella", {
                            dialog: DialogInterface?, which: Int ->

                    }).create().show()}
            })

            /**
             * img_sb_5
             * @method setOnClickListener
             */

            img_sb_5?.setOnClickListener({

                if(row.locations[4].reserved == 1)
                {
                    Toast.makeText(context, "ombrellone già prenotato!", Toast.LENGTH_SHORT).show()

                }else{


                    val builder = AlertDialog.Builder(context)
                    val dialogView = layoutInflater.inflate(R.layout.add_reservation_dialog, null)

                    builder.setView(dialogView)

                    .setPositiveButton("Inserisci", { dialog: DialogInterface?, which: Int ->

                        val addNameTxt = dialogView.findViewById<TextView>(R.id.addNameTxt)
                        val addSurnameTxt = dialogView.findViewById<TextView>(R.id.addSurnameTxt)
                        val addNumberTxt = dialogView.findViewById<TextView>(R.id.addNumberTxt)

                        row.locations[4].name = addNameTxt.text.toString()
                        row.locations[4].surname = addSurnameTxt.text.toString()
                        row.locations[4].phone = addNumberTxt.text.toString()
                        row.locations[4].reserved = 1

                        img_sb_5?.setImageResource(context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))

                    })
                    .setNegativeButton("cancella", {
                            dialog: DialogInterface?, which: Int ->

                    }).create().show()}
            })

            img_sb_1?.setImageResource(context.resources.getIdentifier(row.locations[0].image, "mipmap", context.packageName))
            img_sb_2?.setImageResource(context.resources.getIdentifier(row.locations[1].image, "mipmap", context.packageName))
            img_sb_3?.setImageResource(context.resources.getIdentifier(row.locations[2].image, "mipmap", context.packageName))
            img_sb_4?.setImageResource(context.resources.getIdentifier(row.locations[3].image, "mipmap", context.packageName))
            img_sb_5?.setImageResource(context.resources.getIdentifier(row.locations[4].image, "mipmap", context.packageName))

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sunbed_list_item ,parent,false)


        val reservationReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {}}

        LocalBroadcastManager.getInstance(context).registerReceiver(reservationReceiver, IntentFilter(BROADCAST_RESERVATION_OK_1))



        return Holder(view)
    }

    override fun getItemCount(): Int {
        return rows.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindProduct(rows[position], context)
        val item = rows[position]
    }

}