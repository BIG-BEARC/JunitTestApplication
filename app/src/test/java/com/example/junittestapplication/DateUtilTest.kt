package com.example.junittestapplication

import com.example.junittestapplication.utils.DateUtil

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.text.ParseException
import java.util.*

/**
 *@Description
 *@Author chuxiong
 *@Time 2021/4/14 4:59 PM
 */
@RunWith(Parameterized::class)
class DateUtilTest( var time: String) {
    val dateDime = "2021-04-14 17:00:00"
    private val timeStamp = 1618390800000L
    var date: Date? = null

    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun primeNumbers(): MutableCollection<String> {
            return mutableListOf("2021-04-14",
              //  "2021-04-14 17:00:00",
                "2021年04月14日 17点00分00秒")
        }

    }


    @Before
    fun setUp() {
        println("测试开始！")
        date = Date(timeStamp)
    }

    @After
    fun tearDown() {
        println("测试结束！")
    }

    @Test
    fun stampToDateTest() {
        assertEquals("预期时间", DateUtil.stampToDate(timeStamp))
        //assertEquals(time,DateUtil.stampToDate(timeStamp))
    }

    @Test(expected = ParseException::class)
    fun dateToStampTest() {
        //    assertNotEquals(4,DateUtil.dateToStamp(time))
        assertNotEquals(4, DateUtil.dateToStamp("2021-04-12"))
    }
    @Test(expected = ParseException::class)
    fun dateToStampTest1() {
       println(DateUtil.dateToStamp(time))
    }


}