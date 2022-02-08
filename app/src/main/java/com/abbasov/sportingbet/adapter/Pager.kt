package com.abbasov.sportingbet.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.abbasov.sportingbet.fragment.A
import com.abbasov.sportingbet.fragment.B
import com.abbasov.sportingbet.fragment.C

class Pager (var list: ArrayList<Fragment>, fragmentManager: FragmentManager)
    : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> A()
            1 -> B()
            2 -> C()
            else -> A()

        }
    }
}