package com.aicpa.articles.ui.articleslist.model

/**
 * Created by Noor aka Thor on 6/21/21.
 */
data class SearchResponse(
        var status: String = "",
        var response: SearchBeanContainer = SearchBeanContainer()
)
