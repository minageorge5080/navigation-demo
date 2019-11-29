package com.minageorge.navigationdemo.ui.host.containers

import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment

class OneContainer : BaseFragment() {

    override fun getLayoutId() = R.layout.container_one

    override fun initFragment() {
        setupToolbar(R.id.toolbar_one)
        setupNavigation(R.id.nav_host_one)

        navController?.addOnDestinationChangedListener { controller, destination, arguments ->


        }
    }
}