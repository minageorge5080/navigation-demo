package com.minageorge.navigationdemo.ui.singleactivity.fragments

import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_single_one.*

class SingleOneFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.fragment_single_one

    override fun initFragment() {


        navigateToTwo.setOnClickListener {
            navigateInside(R.id.action_singleOneFragment_to_singleTwoFragment)
        }
    }
}