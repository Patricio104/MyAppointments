package com.patricio.myappointments

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.patricio.myappointments.PreferenceHelper.get
import com.patricio.myappointments.PreferenceHelper.set
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val snackBar by lazy {
        Snackbar.make(mainLayout, R.string.press_back_again, Snackbar.LENGTH_SHORT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //shared preferences
        //val preferences = getSharedPreferences("general", Context.MODE_PRIVATE)
        //val session = preferences.getBoolean("session", false)
        val preferences = PreferenceHelper.defaultPrefs(this)
        if(preferences["session", false])
            goToMenuActivity()

        btn_login.setOnClickListener{
            //validates
            createSessionPreferences()
            goToMenuActivity()
        }

        tvGoToRegister.setOnClickListener{
            Toast.makeText(this, getString(R.string.please_fill_your_register_data), Toast.LENGTH_LONG).show();

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createSessionPreferences() {
        /*
        val preferences = getSharedPreferences("general", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putBoolean("session", true)
        editor.apply()
         */
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = true
    }

    private fun goToMenuActivity(){
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        if(snackBar.isShown)
            super.onBackPressed()
        else
            snackBar.show()
    }
}
