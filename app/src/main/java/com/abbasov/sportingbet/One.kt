package com.abbasov.sportingbet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.abbasov.sportingbet.adapter.Pager
import com.abbasov.sportingbet.databinding.ActivityOneBinding
import com.abbasov.sportingbet.fragment.A
import com.abbasov.sportingbet.fragment.B
import com.abbasov.sportingbet.fragment.C
import com.eftimoff.viewpagertransformers.ZoomInTransformer

class One : AppCompatActivity() {
    lateinit var pager:Pager
    lateinit var binding: ActivityOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val array=ArrayList<Fragment>()
        array.add(A())
        array.add(B())
        array.add(C())
        pager=Pager(array,supportFragmentManager)
        binding.viewpager.adapter=pager
        binding.viewpager.setPageTransformer(true, ZoomInTransformer())
        binding.tabLayout.setupWithViewPager(binding.viewpager)

    }
}