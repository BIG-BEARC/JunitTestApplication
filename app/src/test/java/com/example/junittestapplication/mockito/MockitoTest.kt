package com.example.junittestapplication.mockito

import com.example.junittestapplication.bean.Person
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito.mock

/**
 *@Description
 * 在实际的单元测试中，我们测试的类之间会有或多或少的耦合，导致我们无法顺利的进行测试，
 * 这时我们就可以使用Mockito，Mockito库能够Mock（我喜欢理解为模拟）对象，
 * 替换我们原先依赖的真实对象，这样我们就可以避免外部的影响，只测试本类，得到更准确的结果。
 * 当然它的功能不仅仅只是这些，例如TDD（测试驱动开发）也是一大亮点
 * 原文链接：https://blog.csdn.net/qq_17766199/article/details/78450007
 *
 * Kotlin mock 异常解决办法 https://www.cnblogs.com/figozhg/p/6817848.html
 *
 *@Author chuxiong
 *@Time 2021/4/15 5:14 PM
 */
class MockitoTest {
    /**
     * 方式一：普通方法：
     */
    @Test
    fun testIsNotNull() {
        val person = mock(Person::class.java)
        assertNotNull(person)
    }


}