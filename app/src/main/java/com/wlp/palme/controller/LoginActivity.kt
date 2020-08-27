package com.wlp.palme.controller

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.wlp.palme.R
import com.wlp.palme.domain.AuthObj
import com.wlp.palme.domain.DataDomain
import com.wlp.palme.model.CompleteObj
import com.wlp.palme.model.User
import com.wlp.palme.model.UserObj
import com.wlp.palme.model.UserProfile
import com.wlp.palme.service.EmailService
import com.wlp.palme.service.LoginService
import com.wlp.palme.util.BROADCAST_LOGIN
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        manageSpinner(true, View.INVISIBLE)
    }


    fun onLoginBtnClicked(view : View){

        val user : User = User(nameLoginTxt.text.toString(),passLoginTxt2.text.toString())
        if(cb_notifica_wa.isChecked) AuthObj.notify = "true"
        else AuthObj.notify = "false"
        manageSpinner(false, View.VISIBLE)
        hideKeyboard()
        callLoginUser(user)

    }


    /**
     *
     */

    fun callLoginUser(user : User)
    {
        LoginService.loginUser(this
            ,user,
            {
                    esito: Boolean, messaggio: String ->
                if(esito)
                {
                    try{
                        AuthObj.isLoggIn = true
                        Toast.makeText(this, "user Login successfully", Toast.LENGTH_SHORT).show()
                        callFindProfileByEmail(user)

                    }catch(e : Exception){
                        Toast.makeText(this, "error : ${e.message}", Toast.LENGTH_SHORT).show()
                        manageSpinner(true, View.INVISIBLE)
                    }

                }
                else
                {
                    Toast.makeText(this, "login error : $messaggio", Toast.LENGTH_SHORT).show()
                    manageSpinner(true, View.INVISIBLE)
                }

                CompleteObj.esitoLoginUser = esito
            })

    }

    fun callFindProfileByEmail(user : User)
    {
        EmailService.findProfileByEmail(this
            ,user,
            {
                    esito: Boolean, messaggio: String ->
                if(esito)
                {
                    try{
                        val responseJson : JSONObject = JSONObject(messaggio)

                        val userProfile : UserProfile = UserProfile( responseJson.getString("id")
                            , responseJson.getString("nickname")
                            , responseJson.getString("email")
                            , responseJson.getString("avatarname")
                            , responseJson.getString("avatarcolor"))
                        UserObj.userProfile = userProfile
                        manageSpinner(true, View.INVISIBLE)
                        LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(BROADCAST_LOGIN))
                        finish()

                        Toast.makeText(this, "profile found successfully", Toast.LENGTH_SHORT).show()

                    }catch(e : Exception){
                        Toast.makeText(this, "error : ${e.message}", Toast.LENGTH_SHORT).show()
                        manageSpinner(true, View.INVISIBLE)
                    }

                }
                else
                {
                    Toast.makeText(this, "profile found error : $messaggio", Toast.LENGTH_SHORT).show()
                    manageSpinner(true, View.INVISIBLE)
                    finish()
                }

                CompleteObj.esitoLoginUser = esito
            })

    }

    fun manageSpinner(enable: Boolean, visibility : Int)
    {
        FindReservBar.visibility = visibility;

        nameLoginTxt.isEnabled    = enable
        passLoginTxt.isEnabled   = enable
        FindinBtn.isEnabled = enable
    }


    fun hideKeyboard(){
        val inputManager : InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        if(inputManager.isAcceptingText)
            inputManager.hideSoftInputFromWindow(currentFocus?.windowToken,0)
    }
}
