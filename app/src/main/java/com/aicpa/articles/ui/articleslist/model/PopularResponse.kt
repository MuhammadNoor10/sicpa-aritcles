package com.aicpa.articles.ui.articleslist.model

/**
 * Created by Noor aka Thor on 6/20/21.
 */
data class PopularResponse(
        var status: String = "",
        var results: List<Article> = emptyList()
)
