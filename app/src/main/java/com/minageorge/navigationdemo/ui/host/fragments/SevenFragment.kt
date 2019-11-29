package com.minageorge.navigationdemo.ui.host.fragments

import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_five.*
import kotlinx.android.synthetic.main.fragment_seven.*

class SevenFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_seven

    override fun initFragment() {
        navigateToEight.setOnClickListener {
            navigateInside(R.id.action_dest_seven_to_dest_eight)
        }
    }
}