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
import com.wlp.palme.model.Row
import com.wlp.palme.util.BROADCAST_RESERVATION_OK_1

class RowsAdapterBeach(val context : Context, val rows : List<Row>) :  RecyclerView.Adapter<RowsAdapterBeach.Holder>() {

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

                        row.locations[0].firstname = addNameTxt.text.toString()
                        row.locations[0].surname = addSurnameTxt.text.toString()
                        row.locations[0].phone = addNumberTxt.text.toString()
                        row.locations[0].reserved = 1

                        val bitmap_1 = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))
                        val rounded_1 = RoundedBitmapDrawableFactory.create(context.resources,bitmap_1);

                        rounded_1.cornerRadius = 15f;
                        rounded_1.isCircular = true;

                        img_sb_1.setImageDrawable(rounded_1);

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

                        row.locations[1].firstname = addNameTxt.text.toString()
                        row.locations[1].surname = addSurnameTxt.text.toString()
                        row.locations[1].phone = addNumberTxt.text.toString()
                        row.locations[1].reserved = 1

                        val bitmap_2 = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))
                        val rounded_2 = RoundedBitmapDrawableFactory.create(context.resources,bitmap_2);

                        rounded_2.cornerRadius = 15f;
                        rounded_2.isCircular = true;

                        img_sb_2.setImageDrawable(rounded_2);

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

                        row.locations[2].firstname = addNameTxt.text.toString()
                        row.locations[2].surname = addSurnameTxt.text.toString()
                        row.locations[2].phone = addNumberTxt.text.toString()
                        row.locations[2].reserved = 1

                        val bitmap_3 = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))
                        val rounded_3 = RoundedBitmapDrawableFactory.create(context.resources,bitmap_3);

                        rounded_3.cornerRadius = 15f;
                        rounded_3.isCircular = true;

                        img_sb_3.setImageDrawable(rounded_3);

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

                        row.locations[3].firstname = addNameTxt.text.toString()
                        row.locations[3].surname = addSurnameTxt.text.toString()
                        row.locations[3].phone = addNumberTxt.text.toString()
                        row.locations[3].reserved = 1

                        val bitmap_4 = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))
                        val rounded_4 = RoundedBitmapDrawableFactory.create(context.resources,bitmap_4);

                        rounded_4.cornerRadius = 15f;
                        rounded_4.isCircular = true;

                        img_sb_4.setImageDrawable(rounded_4);

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

                        row.locations[4].firstname = addNameTxt.text.toString()
                        row.locations[4].surname = addSurnameTxt.text.toString()
                        row.locations[4].phone = addNumberTxt.text.toString()
                        row.locations[4].reserved = 1

                        val bitmap_5 = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))
                        val rounded_5 = RoundedBitmapDrawableFactory.create(context.resources,bitmap_5);

                        rounded_5.cornerRadius = 15f;
                        rounded_5.isCircular = true;

                        img_sb_5.setImageDrawable(rounded_5);

                    })
                    .setNegativeButton("cancella", {
                            dialog: DialogInterface?, which: Int ->

                    }).create().show()}
            })

            /**
             *  img_sb_1
             */

            val bitmap_1 = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier(row.locations[0].image, "mipmap", context.packageName))
            val rounded_1 = RoundedBitmapDrawableFactory.create(context.resources,bitmap_1);

            rounded_1.cornerRadius = 15f;
            rounded_1.isCircular = true;

            img_sb_1.setImageDrawable(rounded_1);

            /**
             *  img_sb_2
             */

            val bitmap_2 = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier(row.locations[1].image, "mipmap", context.packageName))
            val rounded_2 = RoundedBitmapDrawableFactory.create(context.resources,bitmap_2);

            rounded_2.cornerRadius = 15f;
            rounded_2.isCircular = true;

            img_sb_2.setImageDrawable(rounded_2);

            /**
             *  3
             */

            val bitmap_3 = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier(row.locations[2].image, "mipmap", context.packageName))
            val rounded_3 = RoundedBitmapDrawableFactory.create(context.resources,bitmap_3);

            rounded_3.cornerRadius = 15f;
            rounded_3.isCircular = true;

            img_sb_3.setImageDrawable(rounded_3);

            /**
             *  4
             */

            val bitmap_4 = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier(row.locations[3].image, "mipmap", context.packageName))
            val rounded_4 = RoundedBitmapDrawableFactory.create(context.resources,bitmap_4);

            rounded_4.cornerRadius = 15f;
            rounded_4.isCircular = true;

            img_sb_4.setImageDrawable(rounded_4);

            /**
             *  1
             */

            val bitmap_5 = BitmapFactory.decodeResource(context.resources, context.resources.getIdentifier(row.locations[4].image, "mipmap", context.packageName))
            val rounded_5 = RoundedBitmapDrawableFactory.create(context.resources,bitmap_5);

            rounded_5.cornerRadius = 15f;
            rounded_5.isCircular = true;

            img_sb_5.setImageDrawable(rounded_5);


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