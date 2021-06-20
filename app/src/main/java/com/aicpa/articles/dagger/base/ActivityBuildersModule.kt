package com.aicpa.articles.dagger.base

import com.aicpa.articles.ui.articleslist.ArticlesListActivity
import com.aicpa.articles.ui.articleslist.viewmodel.ArticleListVMsModule
import com.aicpa.articles.ui.base.BaseActivity
import com.aicpa.articles.ui.main.MainActivity
import com.aicpa.articles.ui.search.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeBaseActivity(): BaseActivity

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSearchActivity(): SearchActivity

    @ContributesAndroidInjector(modules = [ArticleListVMsModule::class])
    abstract fun contributeArticlesListActivity(): ArticlesListActivity
}