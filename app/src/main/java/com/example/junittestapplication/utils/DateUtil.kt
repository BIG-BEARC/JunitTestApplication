package com.example.junittestapplication.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 *@Description
 *@Author chuxiong
 *@Time 2021/4/14 4:32 PM
 */
class DateUtil {
    companion object {
        const val FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss"

        /**
         * 掉此方法输入所要转换的时间输入例如（"2017-11-01 22:11:00"）返回时间戳
         *
         * @param time
         * @return 时间戳
         */
        @JvmStatic
        fun dateToStamp(time: String): Long {
            val sdr = SimpleDateFormat(FORMAT_YMDHMS, Locale.CHINA);
            val date = sdr.parse(time)
            return date?.time ?: -1

        }

        /**
         * 将时间戳转换为时间
         */
        @JvmStatic
        fun stampToDate(longTime: Long): String {
            val simpleDateFormat = SimpleDateFormat(FORMAT_YMDHMS, Locale.CHINA);
            val date = Date(longTime)
            return simpleDateFormat.format(date)
        }
    }
}