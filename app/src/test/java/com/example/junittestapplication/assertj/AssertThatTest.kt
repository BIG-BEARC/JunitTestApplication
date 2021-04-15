package com.example.junittestapplication.assertj

import com.example.junittestapplication.junit.IsMobilePhoneMatcher
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test


/**
 *@Description assertThat测试失败时所显示的具体错误信息
 * assertThat(T actual, Matcher<? super T> matcher);
 *
 * assertThat(String reason, T actual, Matcher<? super T> matcher);
 *
 * reason为断言失败时的输出信息，actual为断言的值，matcher为断言的匹配器。
 *
 *
 *@Author chuxiong
 *@Time 2021/4/14 6:32 PM
 */


class AssertThatTest {
    // kotlin 中 @Rule 变更为 @get:Rule
    // https://www.coder.work/article/48327
    // https://qastack.cn/programming/29945087/kotlin-and-new-activitytestrule-the-rule-must-be-public
    @get:Rule
    var rule = MyRule()

    @Test
    fun testAssertThat() {
        assertThat(null, nullValue())
    }


    @Test
    fun testAssertTha1() {
        assertThat("Hello World", both(startsWith("Hello")).and(endsWith("ld")))
    }

    @Test
    @Throws(Exception::class)
    fun testAssertThat2() {
        assertThat("错误信息:", 1, not(5))
    }

    @Test
    @Throws(Exception::class)
    fun testMobilePhone() {
        assertThat("13588888888",
            IsMobilePhoneMatcher()
        )
    }
}

