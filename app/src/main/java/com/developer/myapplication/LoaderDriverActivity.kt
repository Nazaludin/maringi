package com.developer.myapplication

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.progressindicator.LinearProgressIndicator

class LoaderDriverActivity : AppCompatActivity() {
    private lateinit var loader : LinearProgressIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        setContentView(R.layout.loader_driver)
        loader = findViewById<LinearProgressIndicator>(R.id.progressBar_loader_driver)
        loader.setIndeterminate(false)

        val animation = ObjectAnimator.ofInt(loader, "progress", 0, 100)
        animation.duration = 1000
        animation.repeatCount = 2
        animation.interpolator = DecelerateInterpolator()
        animation.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animator: Animator) {}
            override fun onAnimationEnd(animator: Animator) {
                //do something when the countdown is complete
                startActivity(Intent(this@LoaderDriverActivity, TemuDriverActivity::class.java))
            }

            override fun onAnimationCancel(animator: Animator) {}
            override fun onAnimationRepeat(animator: Animator) {}
        })
        animation.start()
    }

}