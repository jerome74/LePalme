package com.wlp.palme.util

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.wlp.palme.LepalmeActivity
import com.wlp.palme.R
import java.util.*

class DatePickerFragment(var localcontext : Context) : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        /* Use the current date as the default date in the picker */
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(localcontext, this, year, month, day)

    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        val date_tv = (localcontext as LepalmeActivity).findViewById<TextView>((R.id.date_tv))
        val info = (localcontext as LepalmeActivity).findViewById<TextView>((R.id.info))
        date_tv.text = " $day/${month + 1}/$year "
        info.text = ""
    }
}


