package com.aicpa.articles.ui.search

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.aicpa.articles.R
import com.aicpa.articles.constants.ApiConstants
import com.aicpa.articles.databinding.ActivitySearchBinding
import com.aicpa.articles.ui.articleslist.ArticlesListActivity
import com.aicpa.articles.ui.articleslist.ArticlesListActivity.Companion.TYPE_SEARCH
import com.aicpa.articles.ui.base.BaseActivity

class SearchActivity: BaseActivity() {

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        initToolbar()
    }

    private fun initToolbar() {
        binding.toolbarContainer.toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    fun onClickSearch(_unused: View) {
        if (TextUtils.isEmpty(binding.etSearch.text)) {
            Toast.makeText(this, "Please type something to search", Toast.LENGTH_LONG).show()
        } else {
            ArticlesListActivity.start(this, TYPE_SEARCH, ApiConstants.getSearchUrl(binding.etSearch.text.toString()))
        }
    }
}