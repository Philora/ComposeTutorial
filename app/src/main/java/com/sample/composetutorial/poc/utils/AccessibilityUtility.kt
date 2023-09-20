package com.sample.composetutorial.poc.utils

import android.view.View

object AccessibilityUtility {
    @JvmStatic
    fun disableAccessibilityForView(view: View?) {
        view?.contentDescription =
            "\u00A0" //Disable accessibility for textview with giving empty text chars
    }
}