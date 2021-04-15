package com.example.junittestapplication.assertj

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 *@Description 自定义 @Rule 就是实现TestRule 接口，实现apply方法
 *@Author chuxiong
 *@Time 2021/4/15 11:08 AM
 */
open class MyRule : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                // evaluate前执行方法相当于@Before
                val methodName = description.methodName // 获取测试方法的名字
                println("$methodName 测试开始！")

                // 运行的测试方法
                base.evaluate()

                // evaluate后执行方法相当于@After
                println("$methodName 测试结束！")
            }
        }
    }
}