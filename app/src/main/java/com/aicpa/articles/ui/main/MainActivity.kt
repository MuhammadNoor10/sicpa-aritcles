package com.aicpa.articles.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aicpa.articles.R
import com.aicpa.articles.constants.ApiConstants
import com.aicpa.articles.databinding.ActivityMainBinding
import com.aicpa.articles.ui.articleslist.ArticlesListActivity
import com.aicpa.articles.ui.articleslist.ArticlesListActivity.Companion.TYPE_POPULAR
import com.aicpa.articles.ui.base.BaseActivity
import com.aicpa.articles.ui.search.SearchActivity

class MainActivity: BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initLogic()
    }

    private fun initLogic() {
        binding.toolbarContainer.toolbar.navigationIcon = null //cause default the back icon is set in styles
        initListeners()
    }

    private fun initListeners() {
        binding.layoutSearchArticles.tvTitle.setOnClickListener{startActivity(Intent(this, SearchActivity::class.java))}
        binding.layoutMostViewed.tvTitle.setOnClickListener{ArticlesListActivity.start(this, TYPE_POPULAR, ApiConstants.API_MOST_VIEWED)}
        binding.layoutMostShared.tvTitle.setOnClickListener{ArticlesListActivity.start(this, TYPE_POPULAR, ApiConstants.API_MOST_SHARED)}
        binding.layoutMostEmailed.tvTitle.setOnClickListener{ArticlesListActivity.start(this, TYPE_POPULAR, ApiConstants.API_MOST_EMAILED)}
    }
}