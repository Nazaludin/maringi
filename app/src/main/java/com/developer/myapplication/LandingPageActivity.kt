package com.developer.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.developer.myapplication.databinding.ActivityMainBinding

class LandingPageActivity : AppCompatActivity() {
    private lateinit var buttonMasuk: Button
    private lateinit var buttonDaftar: Button
    private lateinit var message: TextView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        sharedPreferences = getSharedPreferences("session-data", MODE_PRIVATE)
        editor= sharedPreferences.edit()
        if (sharedPreferences.getBoolean("is_login", false)) {
            startActivity(Intent(this@LandingPageActivity, MainMenuActivity::class.java))
        }
        setContentView(R.layout.landing_page)

        message = findViewById<TextView>(R.id.textView_motto)

        if(sharedPreferences.getString("email", null)!=null){
            this.message.setText(sharedPreferences.getString("email", null))
        }

        buttonMasuk = findViewById<Button>(R.id.button_masuk)
        buttonMasuk.setOnClickListener {
            startActivity(Intent(this@LandingPageActivity, LoginActivity::class.java))
        }
        buttonDaftar = findViewById<Button>(R.id.button_daftar)
        buttonDaftar.setOnClickListener {
            startActivity(Intent(this@LandingPageActivity, RegisActivity::class.java))
        }
    }


}