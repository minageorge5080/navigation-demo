package com.minageorge.navigationdemo.ui.host.fragments

import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_five.*
import kotlinx.android.synthetic.main.fragment_four.*

class FiveFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_five

    override fun initFragment() {
        navigateToSix.setOnClickListener {
            navigateInside(R.id.action_dest_five_to_dest_six)
        }
    }
}