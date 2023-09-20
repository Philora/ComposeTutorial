package com.sample.composetutorial.poc.utils

import android.view.Gravity
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.sample.composetutorial.R
import com.sample.composetutorial.poc.common.style.applyStyleForPricingUnavailableText
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.Locale

const val NOT_AVAILABLE = "NA"
const val PRICING_UNAVAILABLE = "Pricing Unavailable"
const val EMPTY = ""

object AmountFormatterUtility {

    @BindingAdapter(value = ["originalAmount", "originalAmountDefaultValue"], requireAll = true)
    @JvmStatic
    fun getFormattedAmountWithDollarForXml(
        textView: TextView,
        amount: Any?,
        defaultAmountValue: String
    ) {
        kotlin.run start@{
            if (amount == null) {
                textView.text = defaultAmountValue
                applyStyleForPricingUnavailableText(textView)
                return@start
            }
            if (textView.tag == textView.context.getString(R.string.pharmacy_drug_search_patient_pay_tag)) {
                textView.setTextColor(
                    ContextCompat.getColor(
                        textView.context,
                        R.color.primary_gray
                    )
                )
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
                textView.gravity = Gravity.CENTER_HORIZONTAL
                textView.textSize = 16F
                val typeface = ResourcesCompat.getFont(textView.context, R.font.roboto_bold)
                textView.typeface = typeface
            }
            try {
                val originalAmount: Double = when (amount) {
                    is Int -> amount.toDouble()
                    is String -> amount.toDouble()
                    is Float -> amount.toDouble()
                    else -> amount as Double
                }
                if (originalAmount <= 0) {
                    if (textView.tag == textView.context.getString(R.string.pharmacy_drug_search_patient_pay_price_per_day_tag)) {
                        val fText = "${formatAmountWithDollar(0)} per day"
                        textView.text = fText
                    } else {
                        textView.text = formatAmountWithDollar(0)
                    }
                    return@start
                }
                val convertedOriginalAmount = DecimalFormat("#.##").format(originalAmount)
                val integerValue = originalAmount.toInt()
                if (integerValue > 0) {
                    val isWholeNumber =
                        BigDecimal.ZERO.compareTo(BigDecimal.valueOf(convertedOriginalAmount.toDouble() % integerValue)) == 0
                    if (isWholeNumber) {
                        if (textView.tag == textView.context.getString(R.string.pharmacy_drug_search_patient_pay_price_per_day_tag)) {
                            val fText = "${formatAmountWithDollar(integerValue)} per day"
                            textView.text = fText
                        } else {
                            textView.text = formatAmountWithDollar(integerValue)
                        }
                        return@start
                    }
                }
                if (textView.tag == textView.context.getString(R.string.pharmacy_drug_search_patient_pay_price_per_day_tag)) {
                    val fText =
                        "${formatAmountWithDollar(convertedOriginalAmount.toDouble())} per day"
                    textView.text = fText
                } else {
                    textView.text = formatAmountWithDollar(convertedOriginalAmount.toDouble())
                }
                return@start
            } catch (e: NumberFormatException) {
                textView.text = defaultAmountValue
                applyStyleForPricingUnavailableText(textView)
                return@start
            }
        }
    }

    @Throws(NumberFormatException::class)
    fun getFormattedAmountWithDollar(originalAmount: String?): String {
        var oAmount = originalAmount ?: return formatAmountWithDollar(0)
        // when input is null
        if (oAmount.startsWith("$")) oAmount = oAmount.replace("$", "")
        return getFormattedAmountWithDollar(oAmount.toDouble())
    }

    @JvmStatic
    @Throws(NumberFormatException::class)
    fun getFormattedAmountWithDollar(originalAmount: Double): String {
        if (originalAmount <= 0) return formatAmountWithDollar(0)
        val convertedOriginalAmount = DecimalFormat("#.##").format(originalAmount)
        val integerValue = originalAmount.toInt()
        if (integerValue > 0) {
            val isWholeNumber =
                BigDecimal.ZERO.compareTo(BigDecimal.valueOf(convertedOriginalAmount.toDouble() % integerValue)) == 0
            if (isWholeNumber) return formatAmountWithDollar(integerValue)
        }
        return formatAmountWithDollar(convertedOriginalAmount.toDouble())
    }

    fun getFormattedAmountWithDollarWithZero(originalAmount: Double): String {
        val convertedOriginalAmount = DecimalFormat("#.##").format(originalAmount)
        return formatAmountWithDollar(convertedOriginalAmount.toDouble())
    }

    fun getFormattedAmountWithoutDollarWithZero(originalAmount: Double): String {
        val convertedOriginalAmount = DecimalFormat("#.##").format(originalAmount)
        return formatAmountWithoutDollar(convertedOriginalAmount.toDouble())
    }

    @Throws(NumberFormatException::class)
    private fun getFormattedAmountWithoutDollar(originalAmount: Double): Any {
        val convertedOriginalAmount = DecimalFormat("#.##").format(originalAmount)
        val integerValue = originalAmount.toInt()
        if (integerValue > 0) {
            val isWholeNumber =
                BigDecimal.ZERO.compareTo(BigDecimal.valueOf(convertedOriginalAmount.toDouble() % integerValue)) == 0
            if (isWholeNumber) return integerValue
        }
        return convertedOriginalAmount.toDouble()
    }

    @Throws(NumberFormatException::class)
    fun getFormattedAmountWithoutDollar(originalAmount: String?): Any {
        var oAmount = originalAmount ?: return 0
        // when input is null
        if (oAmount.startsWith("$")) oAmount = originalAmount.replace("$", "")
        val amount = oAmount.toDouble()
        return if (amount <= 0) 0 else getFormattedAmountWithoutDollar(amount)
    }

    private fun formatAmountWithDollar(amount: Double): String {
        return if (amount == 0.00) {
            formatAmountWithDollar(0)
        } else {
            return AppUtils.removeRoundedZerosAfterDecimal(value = amount, formatValue = "$%.2f")
        }
    }

    private fun formatAmountWithoutDollar(amount: Double): String {
        return if (amount == 0.00) {
            formatAmountWithoutDollar(0)
        } else {
            return AppUtils.removeRoundedZerosAfterDecimal(value = amount, formatValue = "%.2f")
        }
    }

    private fun formatAmountWithDollar(amount: Int): String {
        return String.format(Locale.US, "$%,d", amount)
    }

    private fun formatAmountWithoutDollar(amount: Int): String {
        return String.format(Locale.US, "%,d", amount)
    }
}
