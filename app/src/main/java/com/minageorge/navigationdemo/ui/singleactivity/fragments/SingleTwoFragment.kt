package com.minageorge.navigationdemo.ui.singleactivity.fragments

import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_single_two.*

class SingleTwoFragment :BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_single_two

    override fun initFragment() {
        navigateToThree.setOnClickListener {
            navigateInside(R.id.action_singleTwoFragment_to_singleThreeFragment)
        }
    }
}