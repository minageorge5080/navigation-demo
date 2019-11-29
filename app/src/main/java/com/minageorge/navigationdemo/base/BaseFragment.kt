package com.minageorge.navigationdemo.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.minageorge.navigationdemo.R
import com.minageorge.navigationdemo.store.NavigateToAnotherGraph
import com.minageorge.navigationdemo.store.rootDestinations
import com.minageorge.navigationdemo.utils.EventBus

abstract class BaseFragment : Fragment() {


    var toolbar: Toolbar? = null
    var navController: NavController? = null

    private val appBarConfig = AppBarConfiguration.Builder(rootDestinations).build()

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun initFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFragment()
    }

    fun setupToolbar(@IdRes toolbarId: Int) {
        toolbar = requireActivity().findViewById(toolbarId)
    }

    fun setupNavigation(@IdRes navHostId: Int) {
        toolbar?.let { toolbar ->
            navController = requireActivity().findNavController(navHostId).also { controller ->
                NavigationUI.setupWithNavController(toolbar, controller, appBarConfig)
            }
        } ?: kotlin.run {
            navController = requireActivity().findNavController(navHostId)
        }
    }

    fun onBackPressed(): Boolean {
        return navController?.navigateUp(appBarConfig) ?: false
    }

    fun popToRoot(inclusive: Boolean = false) {
        navController?.popBackStack(navController?.graph!!.startDestination, inclusive)
    }

    fun navigateInside(@IdRes destId: Int) {
        view?.findNavController()?.navigate(destId)
    }

    fun navigateInside(@IdRes destId: Int, args: Bundle) {
        view?.findNavController()?.navigate(destId, args)
    }

    fun navigateOutside(@IdRes navId: Int, @IdRes destId: Int) {
        Navigation.findNavController(requireActivity(), navId).navigate(destId)
        when (navId) {
            R.id.nav_host_one -> EventBus.publish(NavigateToAnotherGraph(0))
            R.id.nav_host_two -> EventBus.publish(NavigateToAnotherGraph(1))
            R.id.nav_host_three -> EventBus.publish(NavigateToAnotherGraph(2))
        }
    }

    fun navigateOutside(@IdRes navId: Int, @IdRes destId: Int, args: Bundle) {
        Navigation.findNavController(requireActivity(), navId).navigate(destId, args)
        when (navId) {
            R.id.nav_host_one -> EventBus.publish(NavigateToAnotherGraph(0))
            R.id.nav_host_two -> EventBus.publish(NavigateToAnotherGraph(1))
            R.id.nav_host_three -> EventBus.publish(NavigateToAnotherGraph(2))
        }
    }

    fun handleDeepLink(intent: Intent) = navController?.handleDeepLink(intent) ?: false

}