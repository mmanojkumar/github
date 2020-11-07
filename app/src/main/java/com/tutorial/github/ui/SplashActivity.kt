package com.tutorial.github.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.tutorial.github.R


class SplashActivity : AppCompatActivity(){

    private val handler:Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        handler.postDelayed({
            startActivity(Intent(this@SplashActivity, LatestCommitActivity::class.java))
            finish()
        },2000)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        handler.removeCallbacks(null)
    }

}