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
        Location( "91", "sunbed_green_free", "row_top_sx", "row_top_sx_91")
        ,Location("92", "sunbed_green_free", "row_top_sx", "row_top_sx_91")
        ,Location("93", "sunbed_green_free", "row_top_sx", "row_top_sx_91")
        ,Location("94", "sunbed_green_free", "row_top_sx", "row_top_sx_91"))
    )
    private val row_top_sx_81 = Row ( listOf<Location>(
        Location("81", "sunbed_green_free", "row_top_sx", "row_top_sx_81")
        ,Location("82", "sunbed_green_free", "row_top_sx", "row_top_sx_81")
        ,Location("83", "sunbed_green_free", "row_top_sx", "row_top_sx_81")
        ,Location("84", "sunbed_green_free", "row_top_sx", "row_top_sx_81"))
    )
    private val row_top_sx_71A = Row ( listOf<Location>(
        Location("71/A", "sunbed_green_free", "row_top_sx", "row_top_sx_71A")
        ,Location("72/A", "sunbed_green_free", "row_top_sx", "row_top_sx_71A")
        ,Location("73/A", "sunbed_green_free", "row_top_sx", "row_top_sx_71A")
        ,Location("74/A", "sunbed_green_free", "row_top_sx", "row_top_sx_71A"))
    )
    private val row_top_sx_71 = Row ( listOf<Location>(
        Location("71", "sunbed_green_free", "row_top_sx", "row_top_sx_71")
        ,Location("72", "sunbed_green_free", "row_top_sx", "row_top_sx_71")
        ,Location("73", "sunbed_green_free", "row_top_sx", "row_top_sx_71")
        ,Location("74", "sunbed_green_free", "row_top_sx", "row_top_sx_71"))
    )
    private val row_top_sx_61 = Row ( listOf<Location>(
        Location("61", "sunbed_green_free", "row_top_sx", "row_top_sx_61")
        ,Location("62", "sunbed_green_free", "row_top_sx", "row_top_sx_61")
        ,Location("63", "sunbed_green_free", "row_top_sx", "row_top_sx_61")
        ,Location("64", "sunbed_green_free", "row_top_sx", "row_top_sx_61"))
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
        Location( "95", "sunbed_green_free", "row_top_dx", "row_top_dx_95")
        ,Location("96", "sunbed_green_free", "row_top_dx", "row_top_dx_95")
        ,Location("97", "sunbed_green_free", "row_top_dx", "row_top_dx_95")
        ,Location("98", "sunbed_green_free", "row_top_dx", "row_top_dx_95")
        ,Location("99", "sunbed_green_free", "row_top_dx", "row_top_dx_95"))
    )
    private val row_top_dx_85 = Row ( listOf<Location>(
        Location("85", "sunbed_green_free", "row_top_dx", "row_top_dx_85")
        ,Location("86", "sunbed_green_free", "row_top_dx", "row_top_dx_85")
        ,Location("87", "sunbed_green_free", "row_top_dx", "row_top_dx_85")
        ,Location("88", "sunbed_green_free", "row_top_dx", "row_top_dx_85")
        ,Location("89", "sunbed_green_free", "row_top_dx", "row_top_dx_85"))
    )
    private val row_top_dx_75A = Row ( listOf<Location>(
        Location("75/A", "sunbed_green_free", "row_top_dx", "row_top_dx_75A")
        ,Location("76/A", "sunbed_green_free", "row_top_dx", "row_top_dx_75A")
        ,Location("77/A", "sunbed_green_free", "row_top_dx", "row_top_dx_75A")
        ,Location("78/A", "sunbed_green_free", "row_top_dx", "row_top_dx_75A")
        ,Location("79/A", "sunbed_green_free", "row_top_dx", "row_top_dx_75A"))
    )
    private val row_top_dx_75 = Row ( listOf<Location>(
        Location("75", "sunbed_green_free", "row_top_dx", "row_top_dx_75")
        ,Location("76", "sunbed_green_free", "row_top_dx", "row_top_dx_75")
        ,Location("77", "sunbed_green_free", "row_top_dx", "row_top_dx_75")
        ,Location("78", "sunbed_green_free", "row_top_dx", "row_top_dx_75")
        ,Location("79", "sunbed_green_free", "row_top_dx", "row_top_dx_75"))
    )
    private val row_top_dx_65 = Row ( listOf<Location>(
        Location("65", "sunbed_green_free", "row_top_dx", "row_top_dx_65")
        ,Location("66", "sunbed_green_free", "row_top_dx", "row_top_dx_65")
        ,Location("67", "sunbed_green_free", "row_top_dx", "row_top_dx_65")
        ,Location("68", "sunbed_green_free", "row_top_dx", "row_top_dx_65")
        ,Location("69", "sunbed_green_free", "row_top_dx", "row_top_dx_65"))
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
        Location( "01", "sunbed_free", "row_botton_sx", "row_botton_sx_1")
        ,Location("02", "sunbed_free", "row_botton_sx", "row_botton_sx_1")
        ,Location("03", "sunbed_free", "row_botton_sx", "row_botton_sx_1")
        ,Location("04", "sunbed_free", "row_botton_sx", "row_botton_sx_1")
        ,Location("05", "sunbed_free", "row_botton_sx", "row_botton_sx_1"))
    )
    private val row_botton_sx_11 = Row ( listOf<Location>(
        Location("11", "sunbed_free", "row_botton_sx", "row_botton_sx_11")
        ,Location("12", "sunbed_free", "row_botton_sx", "row_botton_sx_11")
        ,Location("13", "sunbed_free", "row_botton_sx", "row_botton_sx_11")
        ,Location("14", "sunbed_free", "row_botton_sx", "row_botton_sx_11")
        ,Location("15", "sunbed_free", "row_botton_sx", "row_botton_sx_11"))
    )
    private val row_botton_sx_21 = Row ( listOf<Location>(
        Location("21", "sunbed_free", "row_botton_sx", "row_botton_sx_21")
        ,Location("22", "sunbed_free", "row_botton_sx", "row_botton_sx_21")
        ,Location("23", "sunbed_free", "row_botton_sx", "row_botton_sx_21")
        ,Location("24", "sunbed_free", "row_botton_sx", "row_botton_sx_21")
        ,Location("25", "sunbed_free", "row_botton_sx", "row_botton_sx_21"))
    )
    private val row_botton_sx_31 = Row ( listOf<Location>(
        Location("31", "sunbed_free", "row_botton_sx", "row_botton_sx_31")
        ,Location("32", "sunbed_free", "row_botton_sx", "row_botton_sx_31")
        ,Location("33", "sunbed_free", "row_botton_sx", "row_botton_sx_31")
        ,Location("34", "sunbed_free", "row_botton_sx", "row_botton_sx_31")
        ,Location("35", "sunbed_free", "row_botton_sx", "row_botton_sx_31"))
    )
    private val row_botton_sx_41 = Row ( listOf<Location>(
        Location("41", "sunbed_free", "row_botton_sx", "row_botton_sx_41")
        ,Location("42", "sunbed_free", "row_botton_sx", "row_botton_sx_41")
        ,Location("43", "sunbed_free", "row_botton_sx", "row_botton_sx_41")
        ,Location("44", "sunbed_free", "row_botton_sx", "row_botton_sx_41")
        ,Location("45", "sunbed_free", "row_botton_sx", "row_botton_sx_41"))
    )
    private val row_botton_sx_51 = Row ( listOf<Location>(
        Location("51", "sunbed_free", "row_botton_sx", "row_botton_sx_51")
        ,Location("52", "sunbed_free", "row_botton_sx", "row_botton_sx_51")
        ,Location("53", "sunbed_free", "row_botton_sx", "row_botton_sx_51")
        ,Location("54", "sunbed_free", "row_botton_sx", "row_botton_sx_51")
        ,Location("55", "sunbed_free", "row_botton_sx", "row_botton_sx_51"))
    )
    private val row_botton_sx_61 = Row ( listOf<Location>(
        Location("61", "sunbed_free", "row_botton_sx", "row_botton_sx_61")
        ,Location("62", "sunbed_free", "row_botton_sx", "row_botton_sx_61")
        ,Location("63", "sunbed_free", "row_botton_sx", "row_botton_sx_61")
        ,Location("64", "sunbed_free", "row_botton_sx", "row_botton_sx_61")
        ,Location("65", "sunbed_free", "row_botton_sx", "row_botton_sx_61"))
    )
    private val row_botton_sx_71 = Row ( listOf<Location>(
        Location("71", "sunbed_free", "row_botton_sx", "row_botton_sx_71")
        ,Location("72", "sunbed_free", "row_botton_sx", "row_botton_sx_71")
        ,Location("73", "sunbed_free", "row_botton_sx", "row_botton_sx_71")
        ,Location("74", "sunbed_free", "row_botton_sx", "row_botton_sx_71")
        ,Location("75", "sunbed_free", "row_botton_sx", "row_botton_sx_71"))
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

    private val row_botton_dx_6 = Row (listOf<Location>(
        Location( "06", "sunbed_free", "row_botton_dx", "row_botton_dx_6")
        ,Location("07", "sunbed_free", "row_botton_dx", "row_botton_dx_6")
        ,Location("08", "sunbed_free", "row_botton_dx", "row_botton_dx_6")
        ,Location("09", "sunbed_free", "row_botton_dx", "row_botton_dx_6")
        ,Location("10", "sunbed_free", "row_botton_dx", "row_botton_dx_6"))
    )
    private val row_botton_dx_16 = Row ( listOf<Location>(
        Location("16", "sunbed_free", "row_botton_dx", "row_botton_dx_16")
        ,Location("17", "sunbed_free", "row_botton_dx", "row_botton_dx_16")
        ,Location("18", "sunbed_free", "row_botton_dx", "row_botton_dx_16")
        ,Location("19", "sunbed_free", "row_botton_dx", "row_botton_dx_16")
        ,Location("20", "sunbed_free", "row_botton_dx", "row_botton_dx_16"))
    )
    private val row_botton_dx_26 = Row ( listOf<Location>(
        Location("26", "sunbed_free", "row_botton_dx", "row_botton_dx_26")
        ,Location("27", "sunbed_free", "row_botton_dx", "row_botton_dx_26")
        ,Location("28", "sunbed_free", "row_botton_dx", "row_botton_dx_26")
        ,Location("29", "sunbed_free", "row_botton_dx", "row_botton_dx_26")
        ,Location("30", "sunbed_free", "row_botton_dx", "row_botton_dx_26"))
    )
    private val row_botton_dx_36 = Row ( listOf<Location>(
        Location("36", "sunbed_free", "row_botton_dx", "row_botton_dx_36")
        ,Location("37", "sunbed_free", "row_botton_dx", "row_botton_dx_36")
        ,Location("38", "sunbed_free", "row_botton_dx", "row_botton_dx_36")
        ,Location("39", "sunbed_free", "row_botton_dx", "row_botton_dx_36")
        ,Location("40", "sunbed_free", "row_botton_dx", "row_botton_dx_36"))
    )
    private val row_botton_dx_46 = Row ( listOf<Location>(
        Location("46", "sunbed_free", "row_botton_dx", "row_botton_dx_46")
        ,Location("47", "sunbed_free", "row_botton_dx", "row_botton_dx_46")
        ,Location("48", "sunbed_free", "row_botton_dx", "row_botton_dx_46")
        ,Location("49", "sunbed_free", "row_botton_dx", "row_botton_dx_46")
        ,Location("50", "sunbed_free", "row_botton_dx", "row_botton_dx_46"))
    )
    private val row_botton_dx_56 = Row ( listOf<Location>(
        Location("56", "sunbed_free", "row_botton_dx", "row_botton_dx_56")
        ,Location("57", "sunbed_free", "row_botton_dx", "row_botton_dx_56")
        ,Location("58", "sunbed_free", "row_botton_dx", "row_botton_dx_56")
        ,Location("59", "sunbed_free", "row_botton_dx", "row_botton_dx_56")
        ,Location("60", "sunbed_free", "row_botton_dx", "row_botton_dx_56"))
    )
    private val row_botton_dx_66 = Row ( listOf<Location>(
        Location("66", "sunbed_free", "row_botton_dx", "row_botton_dx_66")
        ,Location("67", "sunbed_free", "row_botton_dx", "row_botton_dx_66")
        ,Location("68", "sunbed_free", "row_botton_dx", "row_botton_dx_66")
        ,Location("69", "sunbed_free", "row_botton_dx", "row_botton_dx_66")
        ,Location("70", "sunbed_free", "row_botton_dx", "row_botton_dx_66"))
    )
    private val row_botton_dx_76 = Row ( listOf<Location>(
        Location("76", "sunbed_free", "row_botton_dx", "row_botton_dx_76")
        ,Location("77", "sunbed_free", "row_botton_dx", "row_botton_dx_76")
        ,Location("78", "sunbed_free", "row_botton_dx", "row_botton_dx_76")
        ,Location("79", "sunbed_free", "row_botton_dx", "row_botton_dx_76")
        ,Location("80", "sunbed_free", "row_botton_dx", "row_botton_dx_76"))
    )

    private val row_botton_dx = listOf<Row>(row_botton_dx_6
        ,row_botton_dx_16
        ,row_botton_dx_26
        ,row_botton_dx_36
        ,row_botton_dx_46
        ,row_botton_dx_56
        ,row_botton_dx_66
        ,row_botton_dx_76)




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