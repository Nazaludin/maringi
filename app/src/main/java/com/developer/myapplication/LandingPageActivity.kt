package com.developer.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.developer.myapplication.databinding.ActivityMainBinding

class LandingPageActivity : AppCompatActivity() {
    private lateinit var buttonMasuk: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_page)

        buttonMasuk = findViewById<Button>(R.id.button_masuk)
        buttonMasuk.setOnClickListener {
            startActivity(Intent(this@LandingPageActivity, MapsActivity::class.java))
        }
    }


}