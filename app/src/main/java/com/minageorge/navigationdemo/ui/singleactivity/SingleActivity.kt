package com.minageorge.navigationdemo.ui.singleactivity

import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_single.*

class SingleActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_single

    override fun initActivity() {
        NavigationUI.setupWithNavController(
            toolbar_single,
            Navigation.findNavController(this, R.id.nav_host_single)
        )

    }

}