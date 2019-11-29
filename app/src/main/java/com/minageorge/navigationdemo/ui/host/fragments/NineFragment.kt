package com.minageorge.navigationdemo.ui.host.fragments

import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_nine.*

class NineFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_nine

    override fun initFragment() {
        navigateToTen.setOnClickListener {
            navigateInside(R.id.action_dest_nine_to_dest_ten)
        }
    }
}