package com.example.junittestapplication.junit

import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 *@Description assertThat  自定义匹配器，需要继承BaseMatcher抽象类，实现matches与describeTo方法
 *@Author chuxiong
 *@Time 2021/4/15 10:50 AM
 */
class IsMobilePhoneMatcher : BaseMatcher<String>() {
    /**
     * 给期待断言成功的对象增加描述
     */
    override fun describeTo(description: Description) {
        description.appendText("预计此字符串是手机号码！")
    }

    /**
     * 给断言失败的对象增加描述
     */
    override fun describeMismatch(item: Any, description: Description) {
        description.appendText(item.toString() + "不是手机号码！");
    }

    /**
     * 进行断言判定，返回true则断言成功，否则断言失败
     */
    override fun matches(item: Any?): Boolean {
        if (item == null) {
            return false
        }

        val pattern: Pattern = Pattern.compile("(1|861)([3578])\\d{9}$*")
        val matcher: Matcher = pattern.matcher(item as String)
        return matcher.find()
    }
}