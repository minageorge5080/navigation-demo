package com.minageorge.navigationdemo.ui.host.fragments

import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_one.*

class OneFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_one

    override fun initFragment() {

        navigateToFour.setOnClickListener {
            navigateInside(R.id.action_dest_one_to_dest_four)
        }
    }
}