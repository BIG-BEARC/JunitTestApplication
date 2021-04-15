package com.example.junittestapplication.mockito

import com.example.junittestapplication.bean.Person
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

/**
 *@Description 方法四：MockitoRule方法
 *@Author chuxiong
 *@Time 2021/4/15 6:57 PM
 */
class MockitoRuleTest {
    @Mock //<--使用@Mock注解
    var mPerson: Person? = null

    @get:Rule //<--使用@Rule 注解
    var mockitoRule = MockitoJUnit.rule()

    @Test
    fun testIsNotNull() {
        assertNotNull(mPerson)
    }
}