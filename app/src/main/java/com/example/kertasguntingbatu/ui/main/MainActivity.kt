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
import com.example.kertasguntingbatu.databinding.ActivityMainBinding

@RequiresApi(Build.VERSION_CODES.M)
class MainActivity : AppCompatActivity(), Callback, CallbackDialog {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("nama1")
        binding.tvPemain.text = name

        val btnPemain = arrayOf(
            binding.ivBatu1,
            binding.ivKertas1,
            binding.ivGunting1,
        )
        val btnKomputer = arrayOf(
            binding.ivBatu2,
            binding.ivKertas2,
            binding.ivGunting2,
        )

        val controller = Controller(this)
        btnPemain.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                val hasilKomputer = btnKomputer.random()
                Log.d("${btnPemain[index].contentDescription}", "Pemain click")
                Log.d("$hasilKomputer", "Komputer Memilih")
                hasilKomputer.setBackgroundResource(R.drawable.btn_corner)
                disableClick(false)
                controller.check(
                    btnPemain[index].contentDescription.toString(),
                    hasilKomputer.contentDescription.toString(),
                    name,
                    "COM"
                )
                Toast.makeText(
                    this, "${btnPemain[index].contentDescription}", Toast.LENGTH_SHORT
                ).show()
                btnPemain.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                btnPemain[index].setBackgroundResource(R.drawable.btn_corner)
            }
        }

        binding.ivReset.setOnClickListener {
             Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()
             Log.d("Reset", "Reset click")
            resetGame(android.R.color.transparent, "", "")
        }

//buat btn close
        val ivClose1 = findViewById<ImageView>(R.id.ivClose1)
        ivClose1.setOnClickListener {
            finish()
        }
    }

    private fun disableClick(isEnable: Boolean) {
        binding.ivBatu1.isEnabled = isEnable
        binding.ivKertas1.isEnabled = isEnable
        binding.ivGunting1.isEnabled = isEnable
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
    }

}