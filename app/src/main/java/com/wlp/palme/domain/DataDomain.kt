package com.wlp.palme.domain

import android.os.Build
import androidx.annotation.RequiresApi
import com.wlp.palme.model.Location
import com.wlp.palme.model.Row

object DataDomain
{
    /**
     * rows_top_sx
     */


    private val row_top_sx_91 = Row (listOf<Location>(
        Location( "91", "sunbed_green_free")
        ,Location("92", "sunbed_green_free")
        ,Location("93", "sunbed_green_free")
        ,Location("94", "sunbed_green_free"))
    )
    private val row_top_sx_81 = Row ( listOf<Location>(
        Location("81", "sunbed_green_free")
        ,Location("82", "sunbed_green_free")
        ,Location("83", "sunbed_green_free")
        ,Location("84", "sunbed_green_free"))
    )
    private val row_top_sx_71A = Row ( listOf<Location>(
        Location("71/A", "sunbed_green_free")
        ,Location("72/A", "sunbed_green_free")
        ,Location("73/A", "sunbed_green_free")
        ,Location("74/A", "sunbed_green_free"))
    )
    private val row_top_sx_71 = Row ( listOf<Location>(
        Location("71", "sunbed_green_free")
        ,Location("72", "sunbed_green_free")
        ,Location("73", "sunbed_green_free")
        ,Location("74", "sunbed_green_free"))
    )
    private val row_top_sx_61 = Row ( listOf<Location>(
        Location("61", "sunbed_green_free")
        ,Location("62", "sunbed_green_free")
        ,Location("63", "sunbed_green_free")
        ,Location("64", "sunbed_green_free"))
    )

    private val row_top_sx = listOf<Row>(
        row_top_sx_91
        , row_top_sx_81
        , row_top_sx_71A
        , row_top_sx_71
        , row_top_sx_61)

    /**
     * rows_top_dx
     */

    private val row_top_dx_95 = Row (listOf<Location>(
        Location( "95", "sunbed_green_free")
        ,Location("96", "sunbed_green_free")
        ,Location("97", "sunbed_green_free")
        ,Location("98", "sunbed_green_free")
        ,Location("99", "sunbed_green_free"))
    )
    private val row_top_dx_85 = Row ( listOf<Location>(
        Location("85", "sunbed_green_free")
        ,Location("86", "sunbed_green_free")
        ,Location("87", "sunbed_green_free")
        ,Location("88", "sunbed_green_free")
        ,Location("89", "sunbed_green_free"))
    )
    private val row_top_dx_75A = Row ( listOf<Location>(
        Location("75/A", "sunbed_green_free")
        ,Location("76/A", "sunbed_green_free")
        ,Location("77/A", "sunbed_green_free")
        ,Location("78/A", "sunbed_green_free")
        ,Location("79/A", "sunbed_green_free"))
    )
    private val row_top_dx_75 = Row ( listOf<Location>(
        Location("75", "sunbed_green_free")
        ,Location("76", "sunbed_green_free")
        ,Location("77", "sunbed_green_free")
        ,Location("78", "sunbed_green_free")
        ,Location("79", "sunbed_green_free"))
    )
    private val row_top_dx_65 = Row ( listOf<Location>(
        Location("65", "sunbed_green_free")
        ,Location("66", "sunbed_green_free")
        ,Location("67", "sunbed_green_free")
        ,Location("68", "sunbed_green_free")
        ,Location("69", "sunbed_green_free"))
    )

    private val row_top_dx = listOf<Row>(
        row_top_dx_95
        , row_top_dx_85
        , row_top_dx_75A
        , row_top_dx_75
        , row_top_dx_65)

    /**
     * rows_botton_sx
     */

    private val row_botton_sx_1 = Row (listOf<Location>(
        Location( "01", "sunbed_free")
        ,Location("02", "sunbed_free")
        ,Location("03", "sunbed_free")
        ,Location("04", "sunbed_free")
        ,Location("05", "sunbed_free"))
    )
    private val row_botton_sx_11 = Row ( listOf<Location>(
        Location("11", "sunbed_free")
        ,Location("12", "sunbed_free")
        ,Location("13", "sunbed_free")
        ,Location("14", "sunbed_free")
        ,Location("15", "sunbed_free"))
    )
    private val row_botton_sx_21 = Row ( listOf<Location>(
        Location("21", "sunbed_free")
        ,Location("22", "sunbed_free")
        ,Location("23", "sunbed_free")
        ,Location("24", "sunbed_free")
        ,Location("25", "sunbed_free"))
    )
    private val row_botton_sx_31 = Row ( listOf<Location>(
        Location("31", "sunbed_free")
        ,Location("32", "sunbed_free")
        ,Location("33", "sunbed_free")
        ,Location("34", "sunbed_free")
        ,Location("35", "sunbed_free"))
    )
    private val row_botton_sx_41 = Row ( listOf<Location>(
        Location("41", "sunbed_free")
        ,Location("42", "sunbed_free")
        ,Location("43", "sunbed_free")
        ,Location("44", "sunbed_free")
        ,Location("45", "sunbed_free"))
    )
    private val row_botton_sx_51 = Row ( listOf<Location>(
        Location("51", "sunbed_free")
        ,Location("52", "sunbed_free")
        ,Location("53", "sunbed_free")
        ,Location("54", "sunbed_free")
        ,Location("55", "sunbed_free"))
    )
    private val row_botton_sx_61 = Row ( listOf<Location>(
        Location("61", "sunbed_free")
        ,Location("62", "sunbed_free")
        ,Location("63", "sunbed_free")
        ,Location("64", "sunbed_free")
        ,Location("65", "sunbed_free"))
    )
    private val row_botton_sx_71 = Row ( listOf<Location>(
        Location("71", "sunbed_free")
        ,Location("72", "sunbed_free")
        ,Location("73", "sunbed_free")
        ,Location("74", "sunbed_free")
        ,Location("75", "sunbed_free"))
    )

    private val row_botton_sx = listOf<Row>(row_botton_sx_1
        ,row_botton_sx_11
        ,row_botton_sx_21
        ,row_botton_sx_31
        ,row_botton_sx_41
        ,row_botton_sx_51
        ,row_botton_sx_61
        ,row_botton_sx_71)


    /**
     * rows_botton_dx
     */

    private val row_botton__dx_6 = Row (listOf<Location>(
        Location( "06", "sunbed_free")
        ,Location("07", "sunbed_free")
        ,Location("08", "sunbed_free")
        ,Location("09", "sunbed_free")
        ,Location("10", "sunbed_free"))
    )
    private val row_botton__dx_16 = Row ( listOf<Location>(
        Location("16", "sunbed_free")
        ,Location("17", "sunbed_free")
        ,Location("18", "sunbed_free")
        ,Location("19", "sunbed_free")
        ,Location("20", "sunbed_free"))
    )
    private val row_botton__dx_26 = Row ( listOf<Location>(
        Location("26", "sunbed_free")
        ,Location("27", "sunbed_free")
        ,Location("28", "sunbed_free")
        ,Location("29", "sunbed_free")
        ,Location("30", "sunbed_free"))
    )
    private val row_botton__dx_36 = Row ( listOf<Location>(
        Location("36", "sunbed_free")
        ,Location("37", "sunbed_free")
        ,Location("38", "sunbed_free")
        ,Location("39", "sunbed_free")
        ,Location("40", "sunbed_free"))
    )
    private val row_botton__dx_46 = Row ( listOf<Location>(
        Location("46", "sunbed_free")
        ,Location("47", "sunbed_free")
        ,Location("48", "sunbed_free")
        ,Location("49", "sunbed_free")
        ,Location("40", "sunbed_free"))
    )
    private val row_botton__dx_56 = Row ( listOf<Location>(
        Location("56", "sunbed_free")
        ,Location("57", "sunbed_free")
        ,Location("58", "sunbed_free")
        ,Location("59", "sunbed_free")
        ,Location("60", "sunbed_free"))
    )
    private val row_botton__dx_66 = Row ( listOf<Location>(
        Location("66", "sunbed_free")
        ,Location("67", "sunbed_free")
        ,Location("68", "sunbed_free")
        ,Location("69", "sunbed_free")
        ,Location("70", "sunbed_free"))
    )
    private val row_botton__dx_76 = Row ( listOf<Location>(
        Location("76", "sunbed_free")
        ,Location("77", "sunbed_free")
        ,Location("78", "sunbed_free")
        ,Location("79", "sunbed_free")
        ,Location("80", "sunbed_free"))
    )

    private val row_botton_dx = listOf<Row>(row_botton__dx_6
        ,row_botton__dx_16
        ,row_botton__dx_26
        ,row_botton__dx_36
        ,row_botton__dx_46
        ,row_botton__dx_56
        ,row_botton__dx_66
        ,row_botton__dx_76)




    fun sector(sector: String): List<Row>?
    {
       when(sector)
       {
           "#row_botton_sx#" -> return row_botton_sx
           "#row_botton_dx#" -> return row_botton_dx
           "#row_top_sx#" -> return row_top_sx
           "#row_top_dx#" -> return row_top_dx
       }

        return null;
    }

    fun reset()
    {
        for(rows in row_botton_sx )
            for(location in rows.locations)
                location.reset()

        for(rows in row_botton_dx )
            for(location in rows.locations)
                location.reset()

        for(rows in row_top_sx )
            for(location in rows.locations)
                location.reset()

        for(rows in row_top_dx )
            for(location in rows.locations)
                location.reset()


    }

}