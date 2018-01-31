package cn.xlunzi.hellokotlin.utils

import java.util.*

/**
 * Created by SunLW on 2018/1/30.
 */
object ColorUtil {

    fun getColor(): String {
        var random = Random()
        return "#FF" + toHex(random.nextInt(255)) + toHex(random.nextInt(255)) + toHex(random.nextInt(255))
    }

    private fun toHex(num: Int): String {
        val hexString = Integer.toHexString(num)
        return when (hexString.length) {
            1 -> "0" + hexString
            else -> hexString
        }
    }
}