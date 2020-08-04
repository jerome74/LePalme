package com.wlp.palme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wlp.palme.R
import com.wlp.palme.model.Row

class RowsAdapter(val context : Context, val rows : List<Row>) :  RecyclerView.Adapter<RowsAdapter.Holder>() {

    inner class Holder (itemView: View?) : RecyclerView.ViewHolder(itemView!!)
    {

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

            img_sb_1?.setOnClickListener({
                img_sb_1?.setImageResource(context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))
            })

            img_sb_2?.setOnClickListener({
                img_sb_2?.setImageResource(context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))
            })

            img_sb_3?.setOnClickListener({
                img_sb_3?.setImageResource(context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))
            })

            img_sb_4?.setOnClickListener({
                img_sb_4?.setImageResource(context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))
            })

            img_sb_5?.setOnClickListener({
                img_sb_5?.setImageResource(context.resources.getIdentifier("sunbed_out", "mipmap", context.packageName))
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