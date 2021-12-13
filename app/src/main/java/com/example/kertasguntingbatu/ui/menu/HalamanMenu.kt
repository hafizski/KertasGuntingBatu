package com.example.kertasguntingbatu.ui.menu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.kertasguntingbatu.ui.main.LawanPemain
import com.example.kertasguntingbatu.ui.main.MainActivity
import com.example.kertasguntingbatu.R
import com.google.android.material.snackbar.Snackbar

class HalamanMenu : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_menu)

        val name = intent.getStringExtra("nama1")
        val tvVsCPU = findViewById<TextView>(R.id.tvVsCPU)
        tvVsCPU.text = "$name vs CPU"
        val ivVsCPU = findViewById<ImageView>(R.id.ivVsCPU)
        ivVsCPU.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("nama1", name)
            startActivity(intent)
        }

        val tvVsPemain = findViewById<TextView>(R.id.tvVsPemain)
        tvVsPemain.text = "$name vs Pemain 2"
        val ivVsPemain = findViewById<ImageView>(R.id.ivVsPemain)
        ivVsPemain.setOnClickListener {
            val intent = Intent(this, LawanPemain::class.java)
            intent.putExtra("nama1", name)
            startActivity(intent)
        }

        Snackbar.make(
            findViewById(R.id.viewHalamanMenu),
            "Selamat Datang $name",
            Snackbar.LENGTH_LONG
        ).setAction("TUTUP") {
        }.show()
    }
}