package com.aicpa.articles.ui.articleslist.viewmodel

import androidx.lifecycle.ViewModel
import com.aicpa.articles.dagger.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Noor aka Thor on 4/24/21.
 */
@Module
abstract class ArticleListVMsModule {
    @Binds
    @IntoMap
    @ViewModelKey(ArticlesListViewModel::class)
    abstract fun bindArticlesListViewModel(viewModel: ArticlesListViewModel): ViewModel
}