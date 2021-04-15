package com.example.junittestapplication.mockito

import com.example.junittestapplication.bean.Person
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit

/**
 *@Description mock 常用打桩方法示例：为Mock出的对象中非void方法都将返回默认值，比如int方法将返回0，
 * 对象方法将返回null等，而void方法将什么都不做。“打桩”顾名思义就是将我们Mock出的对象进行操作，
 * 比如提供模拟的返回值等，给Mock打基础。
 *@Author chuxiong
 *@Time 2021/4/15 7:02 PM
 */
class MockitoStubTest {
    @Mock
    lateinit var mPerson: Person

    @get:Rule
    var mockitoRule = MockitoJUnit.rule()

    /**
     * 如果使用doReturn等打桩方法时，语义为：以什么结果返回，当执行什么方法时。
     * 这个两者的区别就是我们熟悉的while与do while。
     * 这类方法主要是为了应对无法使用thenReturn等方法的场景（比如方法为void），可读性来说thenReturn这类更好。
     */
    @Test
    fun testPersonReturn() {
        Mockito.`when`(mPerson.name).thenReturn("小明")
        Mockito.`when`(mPerson.sex).thenThrow(NullPointerException("滑稽：性别不明"))
        // 输出"小明"
        println(mPerson.name)

        Mockito.doReturn("小小").`when`(mPerson).name
        // 输出"小小"
        println(mPerson.name)

        // 抛出异常
        //println(mPerson.sex)
    }

    /**
     * 用thenAnswer拿到了吃进去的东西，将返回结果重新进行处理。
     */
    @Test
    fun testPersonAnswer() {
        Mockito.`when`(mPerson.eat(ArgumentMatchers.anyString())).thenAnswer { invocation ->
            val arguments = invocation.arguments
            arguments[0].toString() + "真好吃"
        }
        //输出：饺子真好吃
        println(mPerson.eat("饺子"))

    }

    @Test
    fun  testPersonRealMethod(){
        Mockito.doCallRealMethod().`when`(mPerson).getAge()
        //调用Person的真实getAge()方法
        println(mPerson.getAge())
    }

    @Test
    fun  testPersonNothing(){
        Mockito.doNothing().doThrow(RuntimeException()).`when`(mPerson).sex=1

        //第一次什么都不做
        mPerson.sex=1
        //异常抛出在下面这行
//        mPerson.setSex(1);
    }

    @Test
    fun testPersonVerifyAfter() {
        Mockito.`when`(mPerson.getAge()).thenReturn(18)
        //延时1s验证
        println(mPerson.getAge())
        println(System.currentTimeMillis())
        Mockito.verify(mPerson, Mockito.after(1000)).getAge()
        println(System.currentTimeMillis())
        Mockito.verify(mPerson,Mockito.atLeast(2)).getAge()
    }

    @Test
    fun testPersonVerifyAtLeast(){
        mPerson.getAge()
        mPerson.getAge()
        //至少验证2次
        Mockito.verify(mPerson,Mockito.atLeast(2)).getAge()
    }


    @Test
    fun testPersonVerifyAtMost(){
        mPerson.getAge()
        //至多验证2次
        Mockito.verify(mPerson,Mockito.atMost(2)).getAge()
    }


    @Test
    fun testPersonVerifyTimes(){
        mPerson.getAge()
        mPerson.getAge()
       // mPerson.getAge()
        //验证方法调用2次
        Mockito.verify(mPerson,Mockito.times(2)).getAge()
    }


    @Test
    fun testPersonVerifyTimes2(){
        mPerson.getAge()
        mPerson.getAge()
        // Mockito.verify(mPerson, Mockito.after(1000)).getAge()
        //验证方法在100ms超时前调用2次
        Mockito.verify(mPerson,Mockito.timeout(100).times(2)).getAge()
    }


}