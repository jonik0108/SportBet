package com.abbasov.sportingbet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.abbasov.sportingbet.adapter.Pager2
import com.abbasov.sportingbet.databinding.ActivityThreeBinding
import com.abbasov.sportingbet.fragment.G
import com.abbasov.sportingbet.fragment.H
import com.abbasov.sportingbet.fragment.M
import com.eftimoff.viewpagertransformers.ZoomInTransformer

class Three : AppCompatActivity() {
    lateinit var binding:ActivityThreeBinding
    lateinit var pager2: Pager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val array=ArrayList<Fragment>()
        array.add(G())
        array.add(H())
        array.add(M())
        pager2=Pager2(array,supportFragmentManager)
        binding.viewpager.adapter=pager2
        binding.viewpager.setPageTransformer(true, ZoomInTransformer())
        binding.tabLayout.setupWithViewPager(binding.viewpager)
    }
}