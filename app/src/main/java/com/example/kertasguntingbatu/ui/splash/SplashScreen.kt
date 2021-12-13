package com.example.kertasguntingbatu.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.kertasguntingbatu.R
import com.example.kertasguntingbatu.ui.landing.SlideScreenActivity

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this, SlideScreenActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

        val image = findViewById<ImageView>(R.id.ivSplash1)
        Glide.with(
            this
        )
            .load("https://raw.githubusercontent.com/hafizski/Batu_kertas_gunting/master/app/src/main/res/drawable-v24/splash_screen1.png")
            .into(image)
    }

}
