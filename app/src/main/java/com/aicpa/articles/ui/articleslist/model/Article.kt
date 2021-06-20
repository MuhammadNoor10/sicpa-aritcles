package com.aicpa.articles.ui.articleslist.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Noor aka Thor on 6/20/21.
 */
data class Article(
        var title:String = "",
        @SerializedName(value = "published_date") var publishedDate: String = ""
)