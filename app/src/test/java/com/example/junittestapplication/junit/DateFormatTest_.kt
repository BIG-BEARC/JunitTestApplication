package com.example.junittestapplication.junit

import com.example.junittestapplication.utils.DateUtil.Companion.dateToStamp
import com.example.junittestapplication.utils.DateUtil.Companion.stampToDate
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.text.ParseException
import java.util.*

/**
 * @Description
 * @Author chuxiong
 * @Time 2021/4/14 7:01 PM
 */
@RunWith(Parameterized::class)
internal class DateFormatTest_(var time: String, var longTime: Long) {

    @Test(expected = ParseException::class)
    fun stampToDateTest() {
        stampToDate(longTime)
    }

    @Test
    @Throws(Exception::class)
    fun dateToStampTest1() {
        dateToStamp(time)
    }

    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun data(): Iterable<Array<Any>> {
            return listOf(
                arrayOf("2017-10-15", 1508054402001L),
                arrayOf("2017年10月15日 16时00分02秒", 1508054402000L)
            )
        }
    }

}