package com.jovandy.ujiantta

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jovandy.ujiantta.ui.signin.SignInActivity
import com.jovandy.ujiantta.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        getTimeFromAndroid()
        logout.setOnClickListener(){
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
    }

    private fun getTimeFromAndroid() {
        val c = Calendar.getInstance()
        val timeOfDay = c[Calendar.HOUR_OF_DAY]
        if (timeOfDay >= 0 && timeOfDay < 12) {
            welcome.setText("Selamat Pagi!")
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            welcome.setText("Selamat Siang!")
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            welcome.setText("Selamat Sore!")
        } else if (timeOfDay >= 21 && timeOfDay < 24) {
            welcome.setText("Selamat Malam!")
        }
    }
}