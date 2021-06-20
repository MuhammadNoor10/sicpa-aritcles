package com.aicpa.articles.ui.articleslist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aicpa.articles.R
import com.aicpa.articles.common.android.arch.NonNullObserver
import com.aicpa.articles.common.android.arch.resource.UIDataState
import com.aicpa.articles.dagger.viewmodel.ViewModelProviderFactory
import com.aicpa.articles.databinding.ActivityArticlesListBinding
import com.aicpa.articles.ui.articleslist.adapter.ArticleListAdapter
import com.aicpa.articles.ui.articleslist.model.Article
import com.aicpa.articles.ui.articleslist.viewmodel.ArticlesListViewModel
import com.aicpa.articles.ui.base.BaseActivity
import javax.inject.Inject

class ArticlesListActivity: BaseActivity() {

    companion object{
        const val TYPE_SEARCH = "search"
        const val TYPE_POPULAR = "popular"

        const val ARGS_URL = "ARGS_URL"
        const val ARGS_TYPE = "ARGS_TYPE"

        fun start(context: Context, type: String, url: String) {
            val intent = Intent(context, ArticlesListActivity::class.java)
            intent.putExtra(ARGS_TYPE, type)
            intent.putExtra(ARGS_URL, url)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var vmf: ViewModelProviderFactory

    private lateinit var binding: ActivityArticlesListBinding
    private lateinit var viewModel: ArticlesListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_articles_list)
        initLogic()
        getContent()
    }

    private fun initLogic() {
        injectViewModel()
        initView()
    }

    private fun initView() {
        binding.toolbarContainer.toolbar.setNavigationOnClickListener{onBackPressed()}
        binding.rvArticlesList.apply {
            layoutManager = LinearLayoutManager(this@ArticlesListActivity)
            adapter = ArticleListAdapter()
        }
    }

    private fun injectViewModel() {
        viewModel = ViewModelProvider(this, vmf).get(ArticlesListViewModel::class.java)
        viewModel.getArticlesState.observe(this, NonNullObserver { state -> getArticlesStateUpdate(state)})
    }

    private fun getContent() {
        intent.getStringExtra(ARGS_URL)?.let {url ->
            intent.getStringExtra(ARGS_TYPE)?.let {type ->
                viewModel.getArticles(type, url)
            }
        }
    }

    private fun getArticlesStateUpdate(state: UIDataState<List<Article>>) {
        if (state.isLoading) showProgressDialog(this) else hideProgressDialog()

        if (state.isError) {
            Toast.makeText(this, state.error?.message, Toast.LENGTH_LONG).show()
        }else if (state.isSuccessful) {
            state.data?.let {
                if (it.isEmpty()) {
                    Toast.makeText(this, "No results found!", Toast.LENGTH_LONG).show()
                } else {
                    getListAdapter().updateData(it)
                }
            }
        }
    }

    private fun getListAdapter(): ArticleListAdapter{
        return binding.rvArticlesList.adapter as ArticleListAdapter
    }
}



























































