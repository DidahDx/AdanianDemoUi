package com.github.didahdx.adaniandemoui.util

import android.graphics.Color
import kotlin.math.min
import kotlin.math.roundToInt

/**
 * @author Daniel Didah on 4/29/22
 */
object ColorUtil {

    fun manipulateColor(color: Int, factor: Float): Int {
        val a: Int = Color.alpha(color)
        val r = (Color.red(color) * factor).roundToInt()
        val g = (Color.green(color) * factor).roundToInt()
        val b = (Color.blue(color) * factor).roundToInt()
        return Color.argb(
            a,
            min(r, 255),
            min(g, 255),
            min(b, 255)
        )
    }

}