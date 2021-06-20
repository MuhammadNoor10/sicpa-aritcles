package com.aicpa.articles.app

import com.aicpa.articles.dagger.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by Noor aka Thor on 6/20/21.
 */
open class ArticlesApp: DaggerApplication() {

    companion object{
        lateinit var instance: ArticlesApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}