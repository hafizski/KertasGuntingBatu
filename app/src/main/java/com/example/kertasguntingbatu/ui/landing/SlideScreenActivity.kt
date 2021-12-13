package com.example.kertasguntingbatu.ui.landing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.kertasguntingbatu.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class SlideScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_screen)
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        val viewPager2 = findViewById<ViewPager2>(R.id.vp2)
        val fragment: ArrayList<Fragment> = arrayListOf(
            Landing1Fragment(),
            Landing2Fragment(),
            Landing3Fragment(),
        )

        val adapter = ViewPagerAdapter(fragment, this)
        viewPager2.adapter = adapter
        dotsIndicator.setViewPager2(viewPager2)

    }
}