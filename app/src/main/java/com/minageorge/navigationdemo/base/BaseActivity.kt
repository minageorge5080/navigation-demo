package com.minageorge.navigationdemo.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity : AppCompatActivity() {

    private val disposable = CompositeDisposable()

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun initActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initActivity()
    }

    fun addToDisposable(disposable: Disposable) {
        this.disposable.remove(disposable)
        this.disposable.add(disposable)
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}