package com.sample.composetutorial.poc.common.style

import android.view.Gravity
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.sample.composetutorial.R

fun applyStyleForPricingUnavailableText(view: TextView?, applyGravity: Boolean = true) {
    if (view?.text == view?.context?.resources?.getString(R.string.pricing_unavailable)) {
        view?.context?.let {
            view.setTextColor(ContextCompat.getColor(it, R.color.primary_gray))
            view.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_price_unavailable_tag,
                0,
                0,
                0
            )
            view.compoundDrawablePadding = it.resources.getDimensionPixelSize(R.dimen._4dp)
            if (applyGravity) {
                view.gravity = Gravity.CENTER_VERTICAL
            }
            view.textSize = 14F
            val typeface = ResourcesCompat.getFont(it, R.font.roboto_medium)
            view.typeface = typeface
        }
    }
}

