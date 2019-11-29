package com.minageorge.navigationdemo.ui.host.fragments

import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_four.*
import kotlinx.android.synthetic.main.fragment_one.*

class FourFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_four

    override fun initFragment() {

        navigateToFive.setOnClickListener {
            navigateInside(R.id.action_dest_four_to_dest_five)
        }
    }
}