package com.minageorge.navigationdemo.ui.host.fragments

import android.os.Bundle
import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_ten.*

class TenFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_ten

    override fun initFragment() {
        setupToolbar(R.id.toolbar_three)
        setupNavigation(R.id.nav_host_three)

        navigateToSix.setOnClickListener {
            navigateOutside(
                R.id.nav_host_one,
                R.id.action_global_dest_six,
                Bundle().apply { putInt("sourceType", 1) })
        }
    }
}