package com.aicpa.articles.ui.articleslist.viewmodel

import com.aicpa.articles.common.android.arch.resource.UIDataState
import com.aicpa.articles.common.android.rx.RxViewModel
import com.aicpa.articles.network.ApiTool
import com.aicpa.articles.ui.articleslist.ArticlesListActivity.Companion.TYPE_SEARCH
import com.aicpa.articles.ui.articleslist.model.Article
import com.aicpa.articles.ui.articleslist.model.PopularResponse
import com.aicpa.articles.ui.articleslist.model.SearchResponse
import com.aicpa.articles.ui.base.BaseUIState
import com.aicpa.articles.utils.DateHelper
import com.aicpa.articles.utils.JsonHelper
import com.google.gson.JsonObject
import rx.Single
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Noor aka Thor on 12/1/20.
 */
class ArticlesListViewModel @Inject constructor(
        private val apiTool: ApiTool,
        val getArticlesState: BaseUIState<List<Article>>
) : RxViewModel() {

    fun getArticles(type: String, url: String) {
        val state: UIDataState<List<Article>>? = getArticlesState.value
        if (state == null || !state.isLoading) {
            getArticlesState.postValue(UIDataState.loading())
            val subscription = Single.defer { apiTool.get(url).toSingle() }
                    .flatMap { jsonObject -> Single.just(parseResponse(type, jsonObject)) }
                    .subscribeOn(Schedulers.io())
                    .subscribe({ paymentResponse -> getArticlesState.postValue(UIDataState.success(paymentResponse)) }
                    ) { error: Throwable -> getArticlesState.postValue(UIDataState.error(error)) }
            compositeDisposable.add(subscription)
        }
    }

    private fun parseResponse(type: String, jsonObject: JsonObject?): List<Article> {
        return when (type) {
            TYPE_SEARCH -> {
                val searchResponse = JsonHelper.parseObject(jsonObject, SearchResponse::class.java)
                searchResponse?.let {
                    val parseList = mutableListOf<Article>()
                    for (bean in searchResponse.response.docs) {
                        parseList.add(Article(bean.headline.main, DateHelper.getOnlyDate(bean.pub_date)))
                    }
                    parseList
                } ?: run {
                    emptyList()
                }
            }
            else -> {
                val response = JsonHelper.parseObject(jsonObject, PopularResponse::class.java)
                response?.results ?: emptyList()
            }
        }
    }
}

























