package com.wlp.palme.domain

import com.wlp.palme.model.Location
import com.wlp.palme.model.Row

object DataDomain
{
    /**
     * rows_top_sx
     */

    val row_top_sx_1 = Row (listOf<Location>(
        Location( "01", "sunbed_free" , 0)
        ,Location("02", "sunbed_free" , 0)
        ,Location("03", "sunbed_free" , 0)
        ,Location("04", "sunbed_free" , 0)
        ,Location("05", "sunbed_out" , 1))
    )
    val row_top_sx_11 = Row ( listOf<Location>(
        Location("11", "sunbed_free" , 0)
        ,Location("12", "sunbed_free" , 0)
        ,Location("13", "sunbed_free" , 0)
        ,Location("14", "sunbed_free" , 0)
        ,Location("15", "sunbed_free" , 0))
    )
    val row_top_sx_21 = Row ( listOf<Location>(
        Location("21", "sunbed_free" , 0)
        ,Location("22", "sunbed_free" , 0)
        ,Location("23", "sunbed_free" , 0)
        ,Location("24", "sunbed_free" , 0)
        ,Location("25", "sunbed_free" , 0))
    )
    val row_top_sx_31 = Row ( listOf<Location>(
        Location("31", "sunbed_free" , 0)
        ,Location("32", "sunbed_free" , 0)
        ,Location("33", "sunbed_free" , 0)
        ,Location("34", "sunbed_free" , 0)
        ,Location("35", "sunbed_free" , 0))
    )
    val row_top_sx_41 = Row ( listOf<Location>(
        Location("41", "sunbed_free" , 0)
        ,Location("42", "sunbed_free" , 0)
        ,Location("43", "sunbed_free" , 0)
        ,Location("44", "sunbed_free" , 0)
        ,Location("45", "sunbed_free" , 0))
    )
    val row_top_sx_51 = Row ( listOf<Location>(
        Location("51", "sunbed_free" , 0)
        ,Location("52", "sunbed_free" , 0)
        ,Location("53", "sunbed_free" , 0)
        ,Location("54", "sunbed_free" , 0)
        ,Location("55", "sunbed_free" , 0))
    )
    val row_top_sx_61 = Row ( listOf<Location>(
        Location("61", "sunbed_free" , 0)
        ,Location("62", "sunbed_free" , 0)
        ,Location("63", "sunbed_free" , 0)
        ,Location("64", "sunbed_free" , 0)
        ,Location("65", "sunbed_free" , 0))
    )
    val row_top_sx_71 = Row ( listOf<Location>(
        Location("71", "sunbed_free" , 0)
        ,Location("72", "sunbed_free" , 0)
        ,Location("73", "sunbed_free" , 0)
        ,Location("74", "sunbed_free" , 0)
        ,Location("75", "sunbed_free" , 0))
    )

    val row_top_sx = listOf<Row>(row_top_sx_1
        ,row_top_sx_11
        ,row_top_sx_21
        ,row_top_sx_31
        ,row_top_sx_41
        ,row_top_sx_51
        ,row_top_sx_61
        ,row_top_sx_71)


    fun sector(sector: String): List<Row>?
    {
       when(sector)
       {
           "#row_top_sx#" -> return row_top_sx
       }

        return null;
    }

}