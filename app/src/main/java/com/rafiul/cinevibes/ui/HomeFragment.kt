package com.rafiul.cinevibes.ui

import com.rafiul.cinevibes.R
import com.rafiul.cinevibes.base.BaseFragment
import com.rafiul.cinevibes.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getFragmentView(): Int {
        return R.layout.fragment_home
    }


}