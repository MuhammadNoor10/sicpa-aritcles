package com.aicpa.articles.utils

import android.text.TextUtils
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Noor aka Thor on 6/21/21.
 */
object DateHelper {
    private const val DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    private const val ONLY_DATE_FORMAT = "yyyy-MM-dd"

    fun getOnlyDate(dateString: String?): String {
        if (dateString.isNullOrEmpty())
            return ""
        try {
            val simpleDateFormat = SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT, Locale.US)
            val fullDateTime = simpleDateFormat.parse(dateString)
            if (fullDateTime != null) {
                val dateOnlyFormat = SimpleDateFormat(ONLY_DATE_FORMAT, Locale.US)
                return dateOnlyFormat.format(fullDateTime)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }
}