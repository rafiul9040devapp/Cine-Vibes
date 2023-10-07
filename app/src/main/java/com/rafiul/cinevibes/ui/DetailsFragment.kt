package com.rafiul.cinevibes.ui

import com.rafiul.cinevibes.R
import com.rafiul.cinevibes.base.BaseFragment
import com.rafiul.cinevibes.databinding.FragmentDetailsBinding


class DetailsFragment :BaseFragment<FragmentDetailsBinding>() {
    override fun getFragmentView(): Int {
        return R.layout.fragment_details
    }

}