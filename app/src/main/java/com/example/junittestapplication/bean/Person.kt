package com.example.junittestapplication.bean

/**
 *@Description
 *@Author chuxiong
 *@Time 2021/4/15 5:16 PM
 */
class Person {
     var name: String? = null
     var sex = 0

    fun getAge(): Int {
        return 11
    }

    fun eat(food: String): String {
        return food
    }

    override fun toString(): String {
        return "Person(name=$name, sex=$sex)"
    }

}