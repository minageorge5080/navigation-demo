package com.minageorge.navigationdemo.ui.host.containers

import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment

class ThreeContainer : BaseFragment() {

    override fun getLayoutId() = R.layout.container_three

    override fun initFragment() {
        setupToolbar(R.id.toolbar_three)
        setupNavigation(R.id.nav_host_three)
    }
}