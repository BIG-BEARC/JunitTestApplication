package com.example.junittestapplication.mockito

import com.example.junittestapplication.bean.Person
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 *@Description 方式三：使用运行器方法：MockitoJUnitRunner
 *@Author chuxiong
 *@Time 2021/4/15 5:52 PM
 */
@RunWith(MockitoJUnitRunner::class) //<--使用MockitoJUnitRunner
class MockitoJUnitRunnerTest {
    @Mock//<--使用@Mock注解
    var mPerson:Person?=null

    @Test
    fun testIsNotNull() {
        Assert.assertNotNull(mPerson)
    }
}