package com.example.kertasguntingbatu.ui.main

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.kertasguntingbatu.ui.landing.DialogHasilFragment
import com.example.kertasguntingbatu.R
import com.example.kertasguntingbatu.controller.Callback
import com.example.kertasguntingbatu.controller.CallbackDialog
import com.example.kertasguntingbatu.controller.Controller
import com.example.kertasguntingbatu.databinding.ActivityLawanPemainBinding

@RequiresApi(Build.VERSION_CODES.M)
class LawanPemain : AppCompatActivity(), Callback, CallbackDialog {
    private lateinit var binding: ActivityLawanPemainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLawanPemainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("nama1")
        binding.tvPemain1.text = name

        val btnPemain = arrayOf(
            binding.ivBatu1,
            binding.ivKertas1,
            binding.ivGunting1,
        )
        val btnPemain2 = arrayOf(
            binding.ivBatu2,
            binding.ivKertas2,
            binding.ivGunting2,
        )

        var hasilPemain1 = ""
        var hasilPemain2 = ""
        disableClick2(false)
        val controller = Controller(this)
        btnPemain.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                hasilPemain1 = btnPemain[index].contentDescription.toString()
                Log.d(hasilPemain1, "Pemain click")
                Log.d(hasilPemain2, "Pemain 2 Memilih")
                disableClick(false)
                disableClick2(true)

                Toast.makeText(
                    this, hasilPemain1, Toast.LENGTH_SHORT
                ).show()
                btnPemain.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                btnPemain[index].setBackgroundResource(R.drawable.btn_corner)
            }
        }

        btnPemain2.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                hasilPemain2 = btnPemain2[index].contentDescription.toString()
                Log.d(hasilPemain1, "Pemain click")
                Log.d(hasilPemain2, "Pemain 2 Memilih")
                disableClick2(false)
                if (hasilPemain1 != "") {
                    controller.check(
                        hasilPemain1, hasilPemain2, name, "Pemain 2"
                    )
                }
                Toast.makeText(
                    this, hasilPemain2, Toast.LENGTH_SHORT
                ).show()
                btnPemain2.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                btnPemain2[index].setBackgroundResource(R.drawable.btn_corner)
            }
        }

        binding.ivReset.setOnClickListener {
            Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()
            Log.d("Reset", "Reset click")
            resetGame(android.R.color.transparent, "", "")
        }

        //buat btn close
        val ivClose2 = findViewById<ImageView>(R.id.ivClose2)
        ivClose2.setOnClickListener {
            finish()
        }
    }

    private fun disableClick(isEnable: Boolean) {
        binding.ivBatu1.isEnabled = isEnable
        binding.ivKertas1.isEnabled = isEnable
        binding.ivGunting1.isEnabled = isEnable
    }

    private fun disableClick2(isEnable: Boolean) {
        binding.ivBatu2.isEnabled = isEnable
        binding.ivKertas2.isEnabled = isEnable
        binding.ivGunting2.isEnabled = isEnable
    }

    override fun hasil(hasil: String) {
        val dialogHasil = DialogHasilFragment()
        val bundle = Bundle()
        bundle.putString("hasil", hasil)
        dialogHasil.arguments = bundle
        dialogHasil.show(supportFragmentManager, "DialogResult")
    }

    override fun resetGame(background: Int, hasilPemain1: String, hasilPemain2: String) {
        binding.ivBatu1.setBackgroundResource(background)
        binding.ivKertas1.setBackgroundResource(background)
        binding.ivGunting1.setBackgroundResource(background)
        binding.ivBatu2.setBackgroundResource(background)
        binding.ivKertas2.setBackgroundResource(background)
        binding.ivGunting2.setBackgroundResource(background)
        disableClick(true)
        disableClick2(false)
    }

}