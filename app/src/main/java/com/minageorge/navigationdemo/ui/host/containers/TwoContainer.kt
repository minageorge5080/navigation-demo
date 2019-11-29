package com.minageorge.navigationdemo.ui.host.containers

import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment

class TwoContainer : BaseFragment() {

    override fun getLayoutId() = R.layout.container_two

    override fun initFragment() {
        setupToolbar(R.id.toolbar_two)
        setupNavigation(R.id.nav_host_two)
    }
}