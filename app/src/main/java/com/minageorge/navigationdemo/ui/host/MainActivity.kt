package com.minageorge.navigationdemo.ui.host

import android.content.Intent
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.base.BaseActivity
import com.minageorge.navigationdemo.store.NavigateToAnotherGraph
import com.minageorge.navigationdemo.ui.host.containers.OneContainer
import com.minageorge.navigationdemo.ui.host.containers.ThreeContainer
import com.minageorge.navigationdemo.ui.host.containers.TwoContainer
import com.minageorge.navigationdemo.utils.EventBus
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity(), ViewPager.OnPageChangeListener,
    BottomNavigationView.OnNavigationItemReselectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

    // list of base destination containers
    private val fragments = listOf(
        OneContainer(),
        TwoContainer(),
        ThreeContainer()
    )

    // map of navigation_id to container index
    private val indexToPage =
        mapOf(0 to R.id.navigation_one, 1 to R.id.navigation_two, 2 to R.id.navigation_three)

    // overall back stack of containers
    private val backStack = Stack<Int>()
    private val pagerAdapter = ViewPagerAdapter()

    private var canExit: Boolean = false

    override fun getLayoutId() = R.layout.activity_main

    override fun initActivity() {

        // setup main view pager
        viewPager.addOnPageChangeListener(this)
        viewPager.adapter = pagerAdapter
        viewPager.post(this::checkDeepLink)
        viewPager.offscreenPageLimit = fragments.size

        // set bottom nav
        bottomNav.setOnNavigationItemSelectedListener(this)
        bottomNav.setOnNavigationItemReselectedListener(this)

        if (backStack.empty()) backStack.push(0)

        addToDisposable(
            EventBus.listen(NavigateToAnotherGraph::class.java)
            .subscribe {
                it?.let { viewPager.currentItem = it.graphPage }
            })
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        val itemId = indexToPage[position] ?: R.id.home
        if (bottomNav.selectedItemId != itemId) bottomNav.selectedItemId = itemId
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        val position = indexToPage.values.indexOf(item.itemId)
        val fragment = fragments[position]
        fragment.popToRoot()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val position = indexToPage.values.indexOf(item.itemId)
        if (viewPager.currentItem != position) setItem(position)
        canExit = false
        return true
    }

    override fun onBackPressed() {
        val fragment = fragments[viewPager.currentItem]
        val hadNestedFragments = fragment.onBackPressed()
        // if no fragments were popped
//        if (!hadNestedFragments) {
//            if (backStack.size > 1) {
//                // remove current position from stack
//                backStack.pop()
//                // set the next item in stack as current
//                viewPager.currentItem = backStack.peek()
//
//            } else super.onBackPressed()
//        }

        if (!hadNestedFragments) {
            if (!canExit) {
                Toast.makeText(this, "please press again to exit.", Toast.LENGTH_SHORT).show()
                canExit = true
            } else {
                finish()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        for (fragment in supportFragmentManager.fragments) {
            fragment.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun setItem(position: Int) {
        viewPager.currentItem = position
        backStack.push(position)
    }


    private fun checkDeepLink() {
        fragments.forEachIndexed { index, fragment ->
            val hasDeepLink = fragment.handleDeepLink(intent)
            if (hasDeepLink) setItem(index)
        }
    }

    inner class ViewPagerAdapter :
        FragmentStatePagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getCount(): Int = fragments.size


    }

}
