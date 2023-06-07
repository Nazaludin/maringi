package com.developer.myapplication

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.progressindicator.LinearProgressIndicator

class TemuDriverActivity : AppCompatActivity() {
    private lateinit var loader : LinearProgressIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        setContentView(R.layout.temu_driver)
        val handler: Handler = Handler()
        val run = object : Runnable {
            override fun run() {
                startActivity(Intent(this@TemuDriverActivity, MainMenuActivity::class.java))
            }
        }
        handler.postDelayed(run, 3000)

    }

//
}