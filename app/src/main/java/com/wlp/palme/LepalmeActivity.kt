package com.wlp.palme

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Message
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.navigation.NavigationView
import com.wlp.palme.controller.*
import com.wlp.palme.controller.handler.SplashHandler
import com.wlp.palme.domain.AuthObj
import com.wlp.palme.domain.DataDomain
import com.wlp.palme.model.CompleteObj
import com.wlp.palme.model.Location
import com.wlp.palme.model.UserObj
import com.wlp.palme.model.UserProfile
import com.wlp.palme.service.EmailService
import com.wlp.palme.service.LocationsService
import com.wlp.palme.util.*
import kotlinx.android.synthetic.main.activity_le_palme.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.nav_header_main.*
import org.json.JSONArray
import org.json.JSONObject

class LepalmeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private var localactivitydate = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_le_palme)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)



        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar
            , R.string.open_navigation_drawer
            , R.string.close_navigation_drawer)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener { true }

        LocalBroadcastManager.getInstance(this).registerReceiver(
            loginReceiver, IntentFilter(
                BROADCAST_LOGIN
            )
        )

        LocalBroadcastManager.getInstance(this).registerReceiver(
            dateReceiver, IntentFilter(
                BROADCAST_DATE
            )
        )

        LocalBroadcastManager.getInstance(this).registerReceiver(
            counterReceiver, IntentFilter(
                BROADCAST_COUNTER
            )
        )

        notifyEventuallyLogin();
    }


    fun onReservationStartBtnClicked(view : MenuItem){

        if (!AuthObj.isLoggIn) {

            Toast.makeText(this, "eseguire il Login!", Toast.LENGTH_SHORT).show()
        }
        else {

            val localIntent: Intent = Intent(this, ReservationActivity::class.java)
            startActivity(localIntent)
        }
    }

    fun onClick_img_sector_botton_dx(view : View){

        if (!AuthObj.isLoggIn) {

            Toast.makeText(this, "eseguire il Login!", Toast.LENGTH_SHORT).show()
        }
        else if (date_tv.text.isNullOrBlank()) {

                Toast.makeText(this, "seleziona data!", Toast.LENGTH_SHORT).show()

        }else {

            val localIntent: Intent = Intent(this, SunbedActivity::class.java)
            localIntent.putExtra("SECTOR", ROW_BOTTON_DX)
            localIntent.putExtra("DATE", localactivitydate)
            startActivity(localIntent)
        }
    }

    fun onClick_img_sector_botton_sx(view : View){

        if (!AuthObj.isLoggIn) {

            Toast.makeText(this, "eseguire il Login!", Toast.LENGTH_SHORT).show()

        }else if (date_tv.text.isNullOrBlank()) {

            Toast.makeText(this, "seleziona data!", Toast.LENGTH_SHORT).show()

        }else {

            val localIntent: Intent = Intent(this, SunbedActivity::class.java)
            localIntent.putExtra("SECTOR", ROW_BOTTON_SX)
            localIntent.putExtra("DATE", localactivitydate)
            startActivity(localIntent)
        }

    }

    fun onClick_img_sector_top_sx(view : View){

        if (!AuthObj.isLoggIn) {

            Toast.makeText(this, "eseguire il Login!", Toast.LENGTH_SHORT).show()

        }else if (date_tv.text.isNullOrBlank()) {

            Toast.makeText(this, "seleziona data!", Toast.LENGTH_SHORT).show()

        }else {

            val localIntent: Intent = Intent(this, SunbedActivityGreenSx::class.java)
            localIntent.putExtra("SECTOR", ROW_TOP_SX)
            localIntent.putExtra("DATE", localactivitydate)
            startActivity(localIntent)
        }
    }

    fun onClick_img_sector_top_dx(view : View){

        if (!AuthObj.isLoggIn) {

            Toast.makeText(this, "eseguire il Login!", Toast.LENGTH_SHORT).show()

        }else if (date_tv.text.isNullOrBlank()) {

            Toast.makeText(this, "seleziona data!", Toast.LENGTH_SHORT).show()

        }else {

            val localIntent: Intent = Intent(this, SunbedActivityGreenDx::class.java)
            localIntent.putExtra("SECTOR", ROW_TOP_DX)
            localIntent.putExtra("DATE", localactivitydate)
            startActivity(localIntent)
        }
    }

    fun showTimePickerDialog(v: View) {

        if (!AuthObj.isLoggIn) {

            Toast.makeText(this, "eseguire il Login!", Toast.LENGTH_SHORT).show()

        }else {
            var datePickerFragment = DatePickerFragment(this)
            datePickerFragment.show(supportFragmentManager, "datePicker")
        }
    }



        fun onLoginBntClicked(view : MenuItem){

        if (!AuthObj.isLoggIn) {
            val intentLogin : Intent = Intent(this, LoginActivity::class.java)
            startActivity(intentLogin)
        }
        else
        {


            var nav_view = findViewById<NavigationView>(R.id.nav_view)
            nav_view.menu.findItem(R.id.loginItem).setTitle("log-In");
            emailTxt.text = ""
            userImg.setImageResource(R.mipmap.profiledefault)

            UserObj.reset()
            AuthObj.reset()
        }

    }

    val loginReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?)
        {
            if (AuthObj.isLoggIn && emailTxt != null && userImg != null)
            {
                emailTxt.text = UserObj.userProfile?.nickname
                var nav_view = findViewById<NavigationView>(R.id.nav_view)
                nav_view.menu.findItem(R.id.loginItem).setTitle("Log-out");

                val identifier = resources.getIdentifier(UserObj.userProfile?.avatarname,"mipmap",packageName)
                val bitmap_1 = BitmapFactory.decodeResource(resources, identifier)
                val rounded_1 = RoundedBitmapDrawableFactory.create(resources,bitmap_1);

                rounded_1.cornerRadius = 15f;
                rounded_1.isCircular = true;

                userImg.setImageDrawable(rounded_1);
            }
        }
    }

    val counterReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?)
        {
            tv_prato_destro.text = "Prato Destro"
            tv_prato_sinistro.text = "Prato Sinistro"
            tv_spiaggia_destra.text = "Spiaggia Destra"
            tv_spiaggia_sinistra.text = "Spiaggia Sinistra"

            tv_prato_destro.text = "${tv_prato_destro.text} : ${DataDomain.number_free_row_top_dx}"
            tv_prato_sinistro.text = "${tv_prato_sinistro.text} : ${DataDomain.number_free_row_top_sx}"
            tv_spiaggia_destra.text = "${tv_spiaggia_destra.text} : ${DataDomain.number_free_row_botton_dx}"
            tv_spiaggia_sinistra.text = "${tv_spiaggia_sinistra.text} : ${DataDomain.number_free_row_botton_sx}"
        }
    }

    val dateReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?)
        {
            var datetime =  intent!!.getStringExtra("datetime")
            val localLocation = Location("","","","")
            localLocation.datetime = datetime

            if(!datetime.equals(localactivitydate)) {
                DataDomain.reset()
                localactivitydate = datetime
            }


            LocationsService.findLocationsByDateTime(context!!
                ,localLocation
            ) { esito: Boolean, messaggio: String ->
                if(esito) {
                    try{
                        if(messaggio.length > 0 && !messaggio.equals("[]")) {
                            val responseJson: JSONArray = JSONArray(messaggio)

                            tv_prato_destro.text = "Prato Destro"
                            tv_prato_sinistro.text = "Prato Sinistro"
                            tv_spiaggia_destra.text = "Spiaggia Destra"
                            tv_spiaggia_sinistra.text = "Spiaggia Sinistra"

                            var i = 0
                            while (i < responseJson.length()) {
                                val rowname = responseJson.getJSONObject(i).getString("rowname")
                                val number = responseJson.getJSONObject(i).getString("number")

                                var sector =  DataDomain.sector("#$rowname#")
                                DataDomain.decreaseNumber("#$rowname#")

                               for( rows in sector!! ) {
                                   for (locallocation in rows.locations) {
                                        if(locallocation.number.equals(number))
                                        {
                                            locallocation.number = responseJson.getJSONObject(i).getString("number")
                                            locallocation.image = responseJson.getJSONObject(i).getString("image")
                                            locallocation.rowname = responseJson.getJSONObject(i).getString("rowname")
                                            locallocation.locationname = responseJson.getJSONObject(i).getString("locationname")
                                            locallocation.reserved = 1
                                            locallocation.firstname = responseJson.getJSONObject(i).getString("firstname")
                                            locallocation.surname = responseJson.getJSONObject(i).getString("surname")
                                            locallocation.phone = responseJson.getJSONObject(i).getString("phone")
                                            locallocation.datetime = responseJson.getJSONObject(i).getString("datetime")

                                            locallocation.id = responseJson.getJSONObject(i).getString("id").toInt()
                                        }
                                   }
                               }
                                i++;
                            }
                        }
                        else
                        {
                            tv_prato_destro.text = "Prato Destro"
                            tv_prato_sinistro.text = "Prato Sinistro"
                            tv_spiaggia_destra.text = "Spiaggia Destra"
                            tv_spiaggia_sinistra.text = "Spiaggia Sinistra"

                            DataDomain.reset()
                        }

                        tv_prato_destro.text = "${tv_prato_destro.text} : ${DataDomain.number_free_row_top_dx}"
                        tv_prato_sinistro.text = "${tv_prato_sinistro.text} : ${DataDomain.number_free_row_top_sx}"
                        tv_spiaggia_destra.text = "${tv_spiaggia_destra.text} : ${DataDomain.number_free_row_botton_dx}"
                        tv_spiaggia_sinistra.text = "${tv_spiaggia_sinistra.text} : ${DataDomain.number_free_row_botton_sx}"

                    }catch(e : Exception){
                        Toast.makeText(context!!, "error : ${e.message}", Toast.LENGTH_SHORT).show()
                    }

                } else {
                    Toast.makeText(context!!, "profile found error : $messaggio", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun notifyEventuallyLogin() {

        if (AuthObj.isLoggIn)
        {
            var nav_view = findViewById<NavigationView>(R.id.nav_view)

            nav_view.menu.findItem(R.id.loginItem).setTitle("Log-out");

            var email = nav_view.getHeaderView(0).findViewById<TextView>(R.id.emailTxt)
            var image = nav_view.getHeaderView(0).findViewById<ImageView>(R.id.userImg)

            email.text = UserObj.userProfile?.nickname

            val identifier = resources.getIdentifier(UserObj.userProfile?.avatarname,"mipmap",packageName)
            val bitmap_1 = BitmapFactory.decodeResource(resources, identifier)
            val rounded_1 = RoundedBitmapDrawableFactory.create(resources,bitmap_1);

            rounded_1.cornerRadius = 15f;
            rounded_1.isCircular = true;

            image.setImageDrawable(rounded_1);
        }
    }

    override fun onResume() {
        super.onResume()

    }
}