package com.aicpa.articles.constants

import com.aicpa.articles.BuildConfig

/**
 * Created by Noor aka Thor on 6/20/21.
 */
object ApiConstants {
    fun getSearchUrl(query: String): String {
        return "${API_SEARCH}q=${query}&api-key=${API_KEY}"
    }

    const val API_KEY = "OmBs7pYkqua5zkf0xfceoTMTkaqMQd0a"

    const val EXCEPTION_NO_INTERNET = "no_internet"
    const val EXCEPTION_SERVER = "network_error"

    const val BASE_URL = BuildConfig.BASE_URL
    const val API_SEARCH = "/svc/search/v2/articlesearch.json?"
    const val API_MOST_VIEWED = "/svc/mostpopular/v2/viewed/1.json?api-key=$API_KEY"
    const val API_MOST_SHARED = "/svc/mostpopular/v2/shared/1/facebook.json?api-key=$API_KEY"
    const val API_MOST_EMAILED = "/svc/mostpopular/v2/emailed/7.json?api-key=$API_KEY"
}