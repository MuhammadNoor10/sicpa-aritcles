package com.aicpa.articles.utils

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Noor aka Thor on 6/21/21.
 */
@RunWith(JUnit4::class)
class DateUtilsTest {

    @Test
    fun getOnlyDate_shouldReturnEmptyString(){
        assert(DateHelper.getOnlyDate(null).isEmpty())
    }
}