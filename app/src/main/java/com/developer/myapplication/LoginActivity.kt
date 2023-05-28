package com.developer.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    private lateinit var buttonMasuk: Button
    private lateinit var buttonBack: ImageButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        setContentView(R.layout.login_page)

        buttonMasuk = findViewById<Button>(R.id.button_masuk_login)
        buttonBack = findViewById<ImageButton>(R.id.imageButton_back_login)

        buttonMasuk.setOnClickListener {
            startActivity(Intent(this@LoginActivity, MainMenuActivity::class.java))
        }
        buttonBack.setOnClickListener {
            startActivity(Intent(this@LoginActivity, LandingPageActivity::class.java))
        }
    }


}