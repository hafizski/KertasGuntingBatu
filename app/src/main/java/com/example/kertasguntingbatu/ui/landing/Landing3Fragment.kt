package com.example.kertasguntingbatu.ui.landing

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.kertasguntingbatu.ui.menu.HalamanMenu
import com.example.kertasguntingbatu.databinding.FragmentLanding3Binding

class Landing3Fragment : Fragment() {

    private lateinit var binding: FragmentLanding3Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLanding3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //button next show up after text inputed
        binding.etNama.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable) {
                binding.ivNext.isVisible = p0.toString().trim().isNotEmpty()
            }

        })
        binding.ivNext.setOnClickListener {
            if (binding.etNama.text.isNotEmpty()) {
                val name = binding.etNama.text.toString()
                binding.etNama.text.clear()
                val intent = Intent(activity, HalamanMenu::class.java)
                intent.putExtra("nama1", name)
                startActivity(intent)
            }
        }
    }

}