package com.developer.myapplication

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.progressindicator.LinearProgressIndicator
import java.util.Timer
import kotlin.concurrent.schedule
import kotlin.concurrent.timer


class TesterActivity : AppCompatActivity() {
    private lateinit var loader : LinearProgressIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        setContentView(R.layout.loader_driver)
        loader = findViewById<LinearProgressIndicator>(R.id.progressBar_loader_driver)
        loader.setIndeterminate(false)
//        setProgress()

        val animation = ObjectAnimator.ofInt(loader, "progress", 0, 100)
        animation.duration = 5000
        animation.repeatCount = 10
        animation.interpolator = DecelerateInterpolator()
        animation.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animator: Animator) {}
            override fun onAnimationEnd(animator: Animator) {
                //do something when the countdown is complete
            }

            override fun onAnimationCancel(animator: Animator) {}
            override fun onAnimationRepeat(animator: Animator) {}
        })
        animation.start()
    }

//    private fun setProgress(){
//
//         Timer().schedule(100, 100){
//            var progress: Int = 0
//            fun run() {
//                progress += 10
//
//                loader.setProgressCompat(progress, true)
//                Log.v("progres", progress.toString())
//                if (progress == 100) {
//                    timer.cancel()
//                }
//            }
//        }
//
//    }
}