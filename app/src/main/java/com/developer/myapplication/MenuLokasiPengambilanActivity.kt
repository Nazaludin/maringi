package com.developer.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.developer.myapplication.ui.donasi.DonasiFragment

class MenuLokasiPengambilanActivity : AppCompatActivity() {
    private lateinit var buttonCariLokasi: Button
    private lateinit var buttonPilihPeta: Button
    private lateinit var buttonBack: ImageButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        setContentView(R.layout.donasi_pilih_lokasi_dengan)

        buttonCariLokasi = findViewById<Button>(R.id.button_cari_lokasi_pengambilan)
        buttonPilihPeta = findViewById<Button>(R.id.button_pilih_lewat_peta)
        buttonBack = findViewById<ImageButton>(R.id.imageButton_back_pilih_lokasi_dengan)

        buttonCariLokasi.setOnClickListener {
            startActivity(Intent(this@MenuLokasiPengambilanActivity, MainMenuActivity::class.java))
        }
        buttonPilihPeta.setOnClickListener {
            startActivity(Intent(this@MenuLokasiPengambilanActivity, MapsActivity::class.java))
        }
        buttonBack.setOnClickListener {
            startActivity(Intent(this@MenuLokasiPengambilanActivity, MainMenuActivity::class.java))
        }
    }
}