package com.developer.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity


class RegisActivity : AppCompatActivity() {
    private lateinit var buttonMasuk: Button
    private lateinit var buttonBack: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        setContentView(R.layout.registrasi_page)

        buttonMasuk = findViewById<Button>(R.id.button_daftar_regis)
        buttonBack = findViewById<ImageButton>(R.id.imageButton_back_regis)

        buttonMasuk.setOnClickListener {
            startActivity(Intent(this@RegisActivity, HomeActivity::class.java))
        }
        buttonBack.setOnClickListener {
            startActivity(Intent(this@RegisActivity, LandingPageActivity::class.java))
        }
    }


}