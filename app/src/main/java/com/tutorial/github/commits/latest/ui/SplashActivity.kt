package com.tutorial.github.commits.latest.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.tutorial.github.R


class SplashActivity : AppCompatActivity(){

    private val handler:Handler = Handler()
    private lateinit var runnable:Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        runnable = Runnable{
            startActivity(Intent(this@SplashActivity, LatestCommitActivity::class.java))
            finish()
        }
        handler.postDelayed(runnable,2000)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        handler.removeCallbacks(runnable)
    }

}