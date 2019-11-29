package com.minageorge.navigationdemo.ui.host.fragments

import android.os.Bundle
import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment

class SixFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_six

    override fun initFragment() {
        setupToolbar(R.id.toolbar_one)
        setupNavigation(R.id.nav_host_one)

        val args = SixFragmentArgs.fromBundle(arguments!!)

        when (args.sourceType) {

            // opened from fragment 10 in nav 3
            1 -> {
                toolbar!!.setNavigationOnClickListener { v ->
                    navigateOutside(R.id.nav_host_three, R.id.action_dest_nine_to_dest_ten)
                    navController?.popBackStack()
                }
            }

        }

    }
}