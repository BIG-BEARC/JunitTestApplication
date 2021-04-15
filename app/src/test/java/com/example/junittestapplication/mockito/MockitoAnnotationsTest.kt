package com.example.junittestapplication.mockito

import com.example.junittestapplication.bean.Person
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 *@Description 方式二：使用 @Mock 注解
 *@Author chuxiong
 *@Time 2021/4/15 5:47 PM
 */
class MockitoAnnotationsTest {
    @Mock //<--使用@Mock注解
    var mPerson: Person? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)// 初始化
    }

    @Test
    fun testIsNotNull() {
        assertNotNull(mPerson)
    }

}