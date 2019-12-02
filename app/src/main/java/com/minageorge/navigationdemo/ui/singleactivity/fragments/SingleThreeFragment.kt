package com.minageorge.navigationdemo.ui.singleactivity.fragments

import android.content.Intent
import androidx.navigation.ActivityNavigator
import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment
import com.minageorge.navigationdemo.ui.host.MainActivity
import kotlinx.android.synthetic.main.fragment_single_three.*

class SingleThreeFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_single_three


    override fun initFragment() {

        navigateToHost.setOnClickListener {
            navigateToActivity(R.id.action_singleThreeFragment_to_mainActivity, null, true)
        }

    }
}