package com.developer.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.developer.myapplication.databinding.ActivityMainBinding

class LandingPageActivity : AppCompatActivity() {
    private lateinit var buttonMasuk: Button
    private lateinit var buttonDaftar: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        setContentView(R.layout.landing_page)

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