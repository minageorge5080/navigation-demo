package com.minageorge.navigationdemo.ui.host.fragments

import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment
import com.minageorge.navigationdemo.store.ActivityBackPressed
import com.minageorge.navigationdemo.utils.EventBus

class SixFragment : BaseFragment() {

    lateinit var args: SixFragmentArgs
    override fun getLayoutId() = R.layout.fragment_six

    override fun initFragment() {
        setupToolbar(R.id.toolbar_one)
        setupNavigation(R.id.nav_host_one)

        args = SixFragmentArgs.fromBundle(arguments!!)

        when (args.sourceType) {
            // opened from fragment 10 in nav 3
            1 -> {
                canProcessBackFromActivity(false)
                toolbar!!.setNavigationOnClickListener { v ->
                    navigateOutside(R.id.nav_host_three, R.id.action_dest_nine_to_dest_ten)
                }
            }
        }
    }

    override fun onActivityBackPressed() {
        when (args.sourceType) {
            // opened from fragment 10 in nav 3
            1 -> {
                navigateOutside(R.id.nav_host_three, R.id.action_dest_nine_to_dest_ten)
            }
        }
    }
}