package com.example.kertasguntingbatu.controller

import android.util.Log

class Controller(private val callback: Callback) : InterfaceController {

    override fun check(hasilPemain1: String, hasilPemain2: String, pemain1: String?, com: String) {
        if (hasilPemain1 == hasilPemain2) {
            callback.hasil("Seri")
            Log.d("Seri", "Click")
        } else if (hasilPemain1 == "Batu" && hasilPemain2 == "Gunting" || hasilPemain1 == "Kertas" && hasilPemain2 == "Batu" || hasilPemain1 == "Gunting" && hasilPemain2 == "Kertas") {
            callback.hasil("$pemain1 Menang")
            Log.d("hasilPemain1_menang", "Click")
        } else {
            callback.hasil("$com Menang")
            Log.d("Hasil: ", "$hasilPemain1 vs $hasilPemain2")
        }
    }
}