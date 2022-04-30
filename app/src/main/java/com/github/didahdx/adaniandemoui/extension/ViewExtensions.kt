package com.github.didahdx.adaniandemoui.extension

import android.view.View

/**
 * @author Daniel Didah on 4/30/22
 */

fun View.show(): View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return this
}

fun View.hide(): View {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
    return this
}