package com.abbasov.inkabet.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abbasov.inkabet.databinding.FragmentMBinding


class M : Fragment() {

    lateinit var binding:FragmentMBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    // Inflate the layout for this fragment
        binding= FragmentMBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }
}