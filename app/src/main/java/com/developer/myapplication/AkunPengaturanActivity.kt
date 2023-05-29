package com.developer.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class AkunPengaturanActivity : AppCompatActivity() {
    private lateinit var buttonSimpan: Button
    private lateinit var buttonBack: ImageButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        setContentView(R.layout.profil_pengaturan)

        buttonSimpan = findViewById<Button>(R.id.button_simpan_profil_pengaturan)
        buttonBack = findViewById<ImageButton>(R.id.imageButton_back_profil_pengaturan)

        buttonSimpan.setOnClickListener {
            startActivity(Intent(this@AkunPengaturanActivity, MainMenuActivity::class.java))
        }
        buttonBack.setOnClickListener {
            startActivity(Intent(this@AkunPengaturanActivity, MainMenuActivity::class.java))
        }
    }


}