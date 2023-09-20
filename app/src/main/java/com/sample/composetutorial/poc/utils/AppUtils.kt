package com.sample.composetutorial.poc.utils

import android.animation.ValueAnimator
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.graphics.PorterDuff
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.VectorDrawable
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Build
import android.telephony.PhoneNumberUtils
import android.text.TextUtils
import android.text.format.DateFormat
import android.util.Base64
import android.util.Log
import android.util.Patterns
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager
import android.view.animation.DecelerateInterpolator
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.sample.composetutorial.R
import org.json.JSONObject
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.regex.Pattern
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import kotlin.math.roundToInt

object AppUtils {
    private val errorTag = AppUtils::class.java.simpleName
    const val PERMISSION_REQUEST_LOCATION = 100
    const val PERMISSION_REQUEST_STORAGE = 300
    val TAG = AppUtils::class.java.name

    @JvmStatic
    fun isExploreByTouchEnabled(activity: Context?): Boolean {
        val am = activity?.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
        val isAccessibilityEnabled = am.isEnabled
        val isExploreByTouchEnabled = am.isTouchExplorationEnabled
        return isAccessibilityEnabled && isExploreByTouchEnabled
    }

    fun isAccessibilityEnabled(activity: Activity): Boolean {
        val am = activity.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
        return am.isEnabled
    }

    fun convertStringToInt(text: String): Int {
        return try {
            text.toInt()
        } catch (ex: NumberFormatException) {
            LogUtils.error("NumberFormatException", "Error converting string to integer")
            0
        }
    }

    @JvmStatic
    fun isEmpty(inputString: String?): Boolean {
        return inputString == null || TextUtils.isEmpty(inputString.trim { it <= ' ' }) || inputString.trim { it <= ' ' }
            .equals("null", ignoreCase = true)
    }

    @JvmStatic
    fun checkNull(context: Context, inputString: String?): String {
        if (inputString != null && !TextUtils.isEmpty(inputString.trim { it <= ' ' }) && !inputString.trim { it <= ' ' }
                .equals("null", ignoreCase = true)
        ) {
            inputString
        } else {
            Toast.makeText(context, R.string.na_only, Toast.LENGTH_LONG).show()
        }
        return inputString.toString()
    }

    @JvmStatic
    fun hasPermissions(context: Context?, vararg permissions: String?): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(
                        context,
                        permission!!,
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return false
                }
            }
        }
        return true
    }

    @JvmStatic
    fun makeCall(context: Context?, phoneNo: String?) {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$phoneNo")
        callIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context?.startActivity(callIntent)
    }

    private fun getBitmapFromView(view: View): Bitmap {
        val width = view.width
        val height = view.height
        val returnedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnedBitmap)
        val bgDrawable = view.background
        if (bgDrawable != null) {
            bgDrawable.draw(canvas)
        } else {
            canvas.drawColor(Color.WHITE)
        }
        view.measure(
            View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY),
        )
        view.layout(view.left, view.top, view.right, view.bottom)
        view.draw(canvas)
        return returnedBitmap
    }

    @JvmStatic
    fun animateExpandCollapseView(v: View?, expand: Boolean, imageView: AppCompatImageView?) {
        if (expand) {
            imageView?.setImageResource(R.drawable.ic_minus)
            imageView?.contentDescription = v?.context?.getString(R.string.collapse_desc)
            v?.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            val targetHeight = v?.measuredHeight
            v?.layoutParams?.height = 0
            v?.visibility = View.VISIBLE
            val valueAnimator = targetHeight?.let { ValueAnimator.ofInt(it) }
            valueAnimator?.addUpdateListener { animation ->
                v.layoutParams?.height = animation.animatedValue as Int
                v.requestLayout()
            }
            valueAnimator?.interpolator = DecelerateInterpolator()
            valueAnimator?.duration = 300
            valueAnimator?.start()
        } else {
            imageView?.setImageResource(R.drawable.ic_plus)
            imageView?.contentDescription = v?.context?.getString(R.string.expand_desc)
            val initialHeight = v?.measuredHeight
            val valueAnimator = initialHeight?.let { ValueAnimator.ofInt(it, 0) }
            valueAnimator?.interpolator = DecelerateInterpolator()
            valueAnimator?.addUpdateListener { animation ->
                v.layoutParams?.height = animation.animatedValue as Int
                v.requestLayout()
                if (animation.animatedValue as Int == 0) v.visibility = View.GONE
            }
            valueAnimator?.interpolator = DecelerateInterpolator()
            valueAnimator?.duration = 300
            valueAnimator?.start()
        }
    }

    @JvmStatic
    fun isEmailValid(email: String?): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    @JvmStatic
    fun RoundToTwoDecimal(quantity: Double?): String {
        val decimalFormat = DecimalFormat("#.##")
        return if (quantity != null) {
            decimalFormat.format(quantity)
        } else {
            "0"
        }
    }

    @JvmStatic
    fun fillWithTwoDecimal(strPrice: String?): String? {
        val twoDecimalFormat = "%.02f"
        var strFormated: String? = null
        try {
            if (strPrice != null && !strPrice.isEmpty()) {
                strFormated =
                    String.format(Locale.getDefault(), twoDecimalFormat, strPrice.toDouble())
            }
        } catch (ex: Exception) {
            LogUtils.error("fillWithTwoDecimal", ex.toString())
        }
        return strFormated
    }

    /**
     * used to convert the price to displaying value with dollar
     *
     * @param price price value
     * @return price with dollar
     */
    @JvmStatic
    fun getPriceWithDollar(price: Double?): String {
        val result = StringBuilder()
        result.append("$")
        try {
            val mVal: Array<String?> = price.toString().split(".").toTypedArray()
            if (mVal.size > 1 && mVal[1] != null && mVal[1]!!.length != 0) {
                if (mVal[1] != "0") {
                    result.append(String.format(Locale.getDefault(), "%.02f", price))
                } else {
                    result.append(String.format(Locale.getDefault(), "%.0f", price))
                }
            } else {
                result.append(price)
            }
        } catch (ex: Exception) {
            LogUtils.error("getPriceWithDollar", ex.toString())
        }
        return result.toString()
    }

    @JvmStatic
    fun getPriceFormate(cost: Double?): String {
        val result = StringBuilder()
        result.append("$")
        if (cost != null) {
            val formatter: NumberFormat = DecimalFormat("#,###.00")
            val formattedNumber: String = formatter.format(cost)
            result.append(formattedNumber)
        }
        return result.toString()
    }

    @JvmStatic
    fun getCopayFormat(cost: Double?): String {
        val zero = 0.00
        if (cost != null) {
            val costString = cost.toString()
            val decimalValue =
                java.lang.Double.valueOf(costString.substring(costString.indexOf(".")))
            val decimalFormat: DecimalFormat = if (decimalValue > zero) {
                DecimalFormat("0.00")
            } else {
                DecimalFormat("#.##")
            }
            return if (cost <= zero) 0.toString() else decimalFormat.format(cost)
        }
        return zero.toString()
    }

    @JvmStatic
    fun getSavingsPercent(cost: Double?): String? {
        val roundData = cost?.roundToInt()
        return if (roundData?.toDouble() == cost) {
            roundData?.toString()
        } else {
            cost?.let value@{
                return@value DecimalFormat("#.#").format(it)
            }
        }
    }

    @JvmStatic
    fun stringToDate(dateString: String?, format: String?): Date? {
        if (dateString == null) return null
        if (format == null) return null
        try {
            val date = SimpleDateFormat(format, Locale.US).parse(dateString)
            return date
        } catch (e: ParseException) {
            LogUtils.error(errorTag, e.toString())
        }
        return null
    }

    @JvmStatic
    fun getFormattedPhoneNumber(phoneNo: String?): String {
        return phoneNo?.takeIf { phone -> phone.isNotBlank() && phone.length == 10 }?.let {
            getFormatNumber(it)
        } ?: ""
    }

    fun getUnformattedPhoneNumber(phone: String?): String? {
        var ph = removeWhiteSpace(phone)
        ph = ph?.replace("\\(".toRegex(), "")
        ph = ph?.replace("\\)".toRegex(), "")
        ph = ph?.replace("-".toRegex(), "")
        return ph
    }

    private fun getFormatNumber(unformattedNumber: String?): String? {
        var fN = try {
            unformattedNumber?.let { PhoneNumberUtils.formatNumber(it, "US") }
        } catch (e: Exception) {
            unformattedNumber?.let { formatPhoneNumberAlternate(it) }
        }
        if (fN?.length == 10) {
            fN = formatPhoneNumberAlternate(fN)
        }
        return fN
    }

    private fun formatPhoneNumberAlternate(value: String): String {
        return try {
            var number = value
            number = number.substring(0, number.length - 4) + "-" + number.substring(
                number.length - 4,
                number.length,
            )
            number = number.substring(0, number.length - 8) + ")" + number.substring(
                number.length - 8,
                number.length,
            )
            number = number.substring(0, number.length - 12) + "(" + number.substring(
                number.length - 12,
                number.length,
            )
            number.replace(")", ") ")
        } catch (e: Exception) {
            ""
        }
    }

    fun dateToString(date: Date?, format: String?): String? {
        if (date == null) return null
        if (format == null) return null
        return SimpleDateFormat(format, Locale.getDefault()).format(date)
    }

    @JvmStatic
    fun changeDateStringFormat(
        currentString: String?,
        currentFormat: String?,
        toFormat: String?,
    ): String? {
        val date = stringToDate(currentString, currentFormat) ?: return null
        return dateToString(date, toFormat)
    }

    /**
     * used to convert the date format from "MM-dd-yyyy" to MM/dd/yyyy
     *
     * @param dateString string date
     * @return formated string
     */
    fun convertToDefaultDateFormat(context: Context, dateString: String?) {
        try {
            if (!isEmpty(dateString)) {
                SimpleDateFormat(AppConstants.APP_DATE_FORMAT, Locale.getDefault())
                    .format(
                        SimpleDateFormat(
                            AppConstants.DOCUMENT_DATE_FORMAT,
                            Locale.getDefault(),
                        ).parse(dateString),
                    )
            } else {
                Toast.makeText(context, R.string.na_only, Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun convertMCUIToServerTimeFormat(context: Context, dateString: String?) {
        try {
            if (!isEmpty(dateString)) {
                val f1 = SimpleDateFormat("h:mm a")
                val d = f1.parse(dateString)
                val f2 = SimpleDateFormat("HHmm")
                f2.format(d)
            } else {
                Toast.makeText(context, R.string.na_only, Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            Toast.makeText(context, R.string.na_only, Toast.LENGTH_LONG).show()
        }
    }

    fun convertToMCTimeFormat(context: Context, dateString: String?) {
        try {
            if (!isEmpty(dateString)) {
                val f1 = SimpleDateFormat("HHmm")
                val d = f1.parse(dateString)
                val f2 = SimpleDateFormat("h:mm a")
                f2.format(d)
            } else {
                Toast.makeText(context, R.string.na_only, Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            Toast.makeText(context, R.string.na_only, Toast.LENGTH_LONG).show()
        }
    }

    fun convertMinToTimeFormat(context: Context, dateString: String?) {
        try {
            if (!isEmpty(dateString)) {
                val f1 = SimpleDateFormat("mm")
                val d = f1.parse(dateString)
                val f2 = SimpleDateFormat("h:mm a")
                f2.format(d)
            } else {
                Toast.makeText(context, R.string.na_only, Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            Toast.makeText(context, R.string.na_only, Toast.LENGTH_LONG).show()
        }
    }

    fun getMinFromDate(time: String?): Int {
        return if (time != null && time !== "") {
            try {
                val hour = time.substring(0, 2).toInt()
                val min = time.substring(2, 4).toInt()
                hour * 60 + min
            } catch (e: Exception) {
                -1
            }
        } else {
            -1
        }
    }

    val currentTimeMCServerFormat: String
        get() {
            val mCurrentTime = Calendar.getInstance()
            val hour = mCurrentTime[Calendar.HOUR_OF_DAY]
            val minute = mCurrentTime[Calendar.MINUTE]
            return String.format("%02d", hour) + "" + String.format("%02d", minute)
        }

    val currentMin: String
        get() {
            val mCurrentTime = Calendar.getInstance()
            return String.format("%02d", mCurrentTime[Calendar.MINUTE])
        }

    val currentHour: String
        get() {
            val mCurrentTime = Calendar.getInstance()
            return String.format("%02d", mCurrentTime[Calendar.HOUR_OF_DAY])
        }

    @JvmStatic
    fun getCurrentDate(format: String?): String? {
        return dateToString(Calendar.getInstance().time, format)
    }

    @JvmStatic
    val currentYear: Int
        get() = Calendar.getInstance()[Calendar.YEAR]

    /**
     * addYearstoCurrentDate is used to add the n years to current date
     *
     * @param numYears can be positive or negative
     * Positive means future year
     * Negative means previous year
     * @return added years to the current date.
     */
    @JvmStatic
    fun addYearstoCurrentDate(numYears: Int): String {
        val dateString = dateToString(Calendar.getInstance().time, AppConstants.REQ_DATE_FORMAT)
        if (dateString != null) {
            val calendar = Calendar.getInstance()
            calendar.time = stringToDate(dateString, AppConstants.REQ_DATE_FORMAT)
            calendar.add(Calendar.YEAR, numYears)
            return dateToString(calendar.time, AppConstants.REQ_DATE_FORMAT) ?: ""
        }
        return ""
    }

    @JvmStatic
    fun parseDateToMMddyyyy(time: String?): String? {
        return if (!TextUtils.isEmpty(time)) {
            val inputPattern = "yyyyMMdd"
            val outputPattern = "MM/dd/yyyy"
            val inputFormat = SimpleDateFormat(inputPattern, Locale.US)
            val outputFormat = SimpleDateFormat(outputPattern, Locale.US)
            val date: Date
            var str: String? = null
            try {
                date = inputFormat.parse(time)
                str = outputFormat.format(date)
            } catch (e: Exception) {
                LogUtils.error("parseDateToMMddyyyy", e.toString())
            }
            str
        } else {
            ""
        }
    }

    fun parseDateTimeStamp(time: Long): String {
        return try {
            val cal = Calendar.getInstance(Locale.ENGLISH)
            cal.timeInMillis = time
            val outputPattern = "MM/dd/yyyy"
            DateFormat.format(outputPattern, cal).toString()
        } catch (e: Exception){
            LogUtils.error("parseDateTimeStamp", e.toString())
        }.toString()
    }

    @JvmStatic
    fun setDateToTextView(context: Context?, textView: TextView?, calendar: Calendar?) {
        val mFormat = context?.getString(R.string.MM_dd_yyyy)
        val sdf = SimpleDateFormat(mFormat, Locale.US)
        textView?.text = sdf.format(calendar?.time)
    }

    @JvmStatic
    fun getCardTypeNumber(cardNumber: String): String {
        var cType: String? = null
        var cTypeNum: String? = null
        if (cardNumber.startsWith("4")) {
            cType = "Visa"
            cTypeNum = "1"
        } else if (cardNumber.startsWith("5")) {
            cType = "MasterCard"
            cTypeNum = "2"
        } else if (cardNumber.startsWith("6")) {
            cType = "Discover"
            cTypeNum = "3"
        } else if (cardNumber.startsWith("3")) {
            cType = "American Express"
            cTypeNum = "4"
        } else {
            cTypeNum = "0"
            cType = "Unknown type"
        }
        return cTypeNum
    }

    @JvmStatic
    fun getCardImageDrawable(cardTypeNum: String): Int {
        var imageDrawable = 0
        imageDrawable = if (cardTypeNum.equals("AMERICAN EXPRESS", ignoreCase = true)) {
            R.drawable.ic_american_express
        } else if (cardTypeNum.equals("DISCOVER", ignoreCase = true)) {
            R.drawable.ic_discover
        } else if (cardTypeNum.equals("VISA", ignoreCase = true)) {
            R.drawable.ic_visa
        } else if (cardTypeNum.equals("MASTER CARD", ignoreCase = true)) {
            R.drawable.ic_mastercard
        } else {
            R.drawable.ic_card_placeholder
        }
        return imageDrawable
    }

    @JvmStatic
    fun removeWhiteSpace(s: String?): String? {
        return s?.replace("\\s+".toRegex(), "")
    }

    /**
     * used to get the Logged in user is MID or NON MID
     *
     * @param groups User Group
     */
    fun isExists(groups: ArrayList<String>?, matchString: String?): Boolean {
        groups?.let {
            for (group in it) {
                if (group.equals(matchString, ignoreCase = true)) return true
            }
        }
        return false
    }

    // Return true if the card number is valid
    fun isValidCard(number: Long): Boolean {
        return getSize(number) >= 13 &&
                getSize(number) <= 16 &&
                (
                        prefixMatched(number, 4) ||
                                prefixMatched(number, 5) ||
                                prefixMatched(number, 37) ||
                                prefixMatched(number, 6)
                        ) &&
                (
                        sumOfDoubleEvenPlace(number) +
                                sumOfOddPlace(number)
                        ) % 10 == 0
    }

    // Luhn Algorithm to check credit card number
    @JvmStatic
    fun isValidCard(ccNumber: String): Boolean {
        var sum = 0
        var alternate = false
        for (i in ccNumber.length - 1 downTo 0) {
            var n = ccNumber.substring(i, i + 1).toInt()
            if (alternate) {
                n *= 2
                if (n > 9) {
                    n = n % 10 + 1
                }
            }
            sum += n
            alternate = !alternate
        }
        return sum % 10 == 0
    }

    // Get the result from Step 2
    private fun sumOfDoubleEvenPlace(number: Long): Int {
        var sum = 0
        val num = number.toString() + ""
        var i = getSize(number) - 2
        while (i >= 0) {
            sum += getDigit((num[i].toString() + "").toInt() * 2)
            i -= 2
        }
        return sum
    }

    // Return this number if it is a single digit, otherwise,
    // return the sum of the two digits
    private fun getDigit(number: Int): Int {
        return if (number < 9) number else number / 10 + number % 10
    }

    // Return sum of odd-place digits in number
    private fun sumOfOddPlace(number: Long): Int {
        var sum = 0
        val num = number.toString() + ""
        var i = getSize(number) - 1
        while (i >= 0) {
            sum += (num[i].toString() + "").toInt()
            i -= 2
        }
        return sum
    }

    // Return true if the digit d is a prefix for number
    private fun prefixMatched(number: Long, d: Int): Boolean {
        return getPrefix(number, getSize(d.toLong())) == d.toLong()
    }

    // Return the number of digits in d
    private fun getSize(d: Long): Int {
        val num = d.toString() + ""
        return num.length
    }

    // Return the first k number of digits from
    // number. If the number of digits in number
    // is less than k, return number.
    private fun getPrefix(number: Long, k: Int): Long {
        if (getSize(number) > k) {
            val num = number.toString() + ""
            return num.substring(0, k).toLong()
        }
        return number
    }

    /**
     * This method generates HMacSHA256 string
     *
     * @param key     - String
     * @param message - String
     * @return
     */
    @JvmStatic
    fun generateSHA256(key: String, message: String): String {
        var encodedStr = ""
        try {
            val hasher = Mac.getInstance("HmacSHA256")
            hasher.init(SecretKeySpec(key.toByteArray(), "HmacSHA256"))
            val hash = hasher.doFinal(message.toByteArray())
            encodedStr = Base64.encodeToString(hash, Base64.NO_WRAP)
            LogUtils.info("SHA256===>", encodedStr)
        } catch (e: NoSuchAlgorithmException) {
            LogUtils.error("NoSuchAlgorithmException", e.toString())
        } catch (e: InvalidKeyException) {
            LogUtils.error("InvalidKeyException", e.toString())
        }
        return encodedStr
    }

    fun getPointFromView(view: View): Point {
        val outLocation = intArrayOf(0, 0)
        view.getLocationOnScreen(outLocation)
        return Point(outLocation[0], outLocation[1])
    }

    /**
     * This method will return the current date
     *
     * @return - Date - Return Current Date
     */
    val currentDate: Date
        get() {
            val format = SimpleDateFormat(AppConstants.APP_DATE_FORMAT, Locale.US)
            var currentDate: Date = Date()
            try {
                currentDate = format.parse(format.format(Date()))
            } catch (e: ParseException) {
                LogUtils.error(errorTag, e.toString())
            }
            return currentDate
        }

    /**
     * This method will return the date after adding up the passed no of months
     *
     * @param months - integer argument that add the no of months
     * @return - Date - Returns the calculated date
     */
    @JvmStatic
    fun getDateXMonthsAgo(months: Int): Date? {
        val cal = Calendar.getInstance()
        cal.add(Calendar.MONTH, months)
        val format = SimpleDateFormat(AppConstants.APP_DATE_FORMAT, Locale.US)
        var calculatedDate: Date? = null
        try {
            calculatedDate = format.parse(format.format(cal.time))
        } catch (e: ParseException) {
            LogUtils.error(errorTag, e.toString())
        }
        return calculatedDate
    }

    /**
     * This method will convert the String to date
     *
     * @param dateString - String - Date String
     * @return - Date - Converts String to date
     */
    @JvmStatic
    fun convertStringToDate(dateString: String?): Date? {
        val format = SimpleDateFormat(AppConstants.APP_DATE_FORMAT, Locale.US)
        var date: Date? = null
        try {
            date = format.parse(dateString)
        } catch (e: ParseException) {
            LogUtils.error(errorTag, e.toString())
        }
        return date
    }

    //    Get phone number from entered format
    @JvmStatic
    fun getValidNumber(mNumber: String): String {
        return mNumber.replace("(", "").replace(")", "").replace(" ", "").replace("-", "")
    }

    @JvmStatic
    fun getBitmap(context: Context?, drawableId: Int, color: Int): Bitmap? {
        val drawable = ContextCompat.getDrawable(context!!, drawableId)
        drawable?.setColorFilter(color, PorterDuff.Mode.SRC_IN)
        return drawable?.let { getBitmapFromDrawable(context, drawableId, it) }
    }

    private fun getBitmapFromDrawable(
        context: Context,
        drawableId: Int,
        drawable: Drawable,
    ): Bitmap? {
        return if (drawable is BitmapDrawable) {
            BitmapFactory.decodeResource(context.resources, drawableId)
        } else if (drawable is VectorDrawable) {
            getBitmap(drawable)
        } else {
            throw java.lang.IllegalArgumentException("unsupported drawable type")
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun getBitmap(vectorDrawable: VectorDrawable): Bitmap {
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888,
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
        vectorDrawable.draw(canvas)
        return bitmap
    }

    fun getBitmapFromVectorDrawable(
        context: Context?,
        drawableId: Int,
        priceColor: String?,
    ): Bitmap? {
        context?.let {
            DrawableCompat.wrap(
                LayerDrawable(
                    arrayOf(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_map_pin_orange,
                        ),
                        ContextCompat.getDrawable(context, drawableId)?.apply {
                            priceColor?.let {
                                DrawableCompat.setTint(this, Color.parseColor(priceColor))
                            }
                        },
                    ),
                ),
            )?.apply {
                return Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
                    .apply {
                        Canvas(this).apply {
                            setBounds(0, 0, width, height)
                            draw(this)
                        }
                    }
            }
        }

        return null
    }

    fun highlightIcon(context: Context, icon: Int, colorCode: Int): Bitmap? {
        val drawable = ContextCompat.getDrawable(context, icon)
        drawable!!.setColorFilter(context.resources.getColor(colorCode), PorterDuff.Mode.SRC_IN)
        var bitmap: Bitmap? = null
        val redMapPin = ContextCompat.getDrawable(context, icon)
        if (drawable is BitmapDrawable) {
            val bitmapDrawable = drawable
            if (bitmapDrawable.bitmap != null) {
                return bitmapDrawable.bitmap
            }
        }
        bitmap = if (drawable.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0) {
            Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
        } else {
            Bitmap.createBitmap(
                redMapPin!!.intrinsicWidth,
                redMapPin.intrinsicHeight,
                Bitmap.Config.ARGB_8888,
            )
        }
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

    fun isJSONObject(str: String?): Boolean {
        try {
            JSONObject(str)
        } catch (e: Exception) {
            return false
        }
        return true
    }

    fun convertSpToPixels(sp: Float, context: Context): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_PX,
            sp,
            context.resources.displayMetrics,
        )
    }

    interface CallListener {
        fun onCall()
    }

    fun retrieveVideoFrameFromVideo(videoPath: String?): Bitmap? {
        var bitmap: Bitmap? = null
        var mediaMetadataRetriever: MediaMetadataRetriever? = null
        try {
            mediaMetadataRetriever = MediaMetadataRetriever()
            mediaMetadataRetriever.setDataSource(videoPath, HashMap<String, String>())
            bitmap = mediaMetadataRetriever.frameAtTime
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            mediaMetadataRetriever?.release()
        }
        return bitmap
    }

    fun getOneDpToPixel(context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            1f,
            context.resources.displayMetrics,
        ).toInt()
    }

    fun dpToPx(context: Context, dp: Int): Int {
        return (dp * context.resources.displayMetrics.density).toInt()
    }

    fun pxToDp(context: Context, px: Int): Int {
        return (px / context.resources.displayMetrics.density).toInt()
    }

    fun isFutureBenefitsDateIsPastCurrentDate(futureBenefitStartDate: String?): Boolean? {
        futureBenefitStartDate?.let { effectiveDate ->
            if (effectiveDate.isNotBlank() && effectiveDate != "N/A") {
                val currentDate = SimpleDateFormat(
                    "yyyyMMdd",
                    Locale.getDefault(),
                ).format(Calendar.getInstance().time)
                val eDate: Date = AppUtils.stringToDate(effectiveDate, "yyyyMMdd")!!
                val cDate: Date = AppUtils.stringToDate(currentDate, "yyyyMMdd")!!
                return eDate < cDate || eDate.compareTo(cDate) == 0
            }
        }
        return null
    }

    fun openFileOrFolder(path: String?) {
    }

    fun writeFile(path: String?) {
    }

    fun isValidUSZipCode(postalCode: CharSequence?): Boolean {
        // Valid ZIP codes
        val valid1 = "12345"
        val valid2 = "12345-6789"

        // Invalid ZIP codes
        val invalid1 = "123456"
        val invalid2 = "1234"
        val invalid3 = "12345-678"
        val invalid4 = "12345-67890"
        val regex = "^[0-9]{5}(?:-[0-9]{4})?$"
        val pattern: Pattern = Pattern.compile(regex)
        postalCode?.let {
            val matcher = pattern.matcher(it)
            val isValid = matcher.matches()
            // AppUtils.showCustomToast(if(isValid) "Valid zipcode" else "Invalid zipcode")
            return isValid
        } ?: kotlin.run {
            // AppUtils.showCustomToast("Invalid zipcode")
            return false
        }
    }

    fun openInBrowserWithUri(uri: Uri?, context: Context?) {
        val browserIntent = Intent(Intent.ACTION_VIEW)
        browserIntent.setDataAndType(uri, "application/pdf")
        browserIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        browserIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        browserIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        browserIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }

    fun removeRoundedZerosAfterDecimal(value: Double, formatValue: String): String {
        val value1 = String.format(Locale.US, formatValue, value)
        val resultSet: List<String> = value1.split("\\.".toRegex())
        return if (resultSet.isNotEmpty() && resultSet.size == 2) {
            if (resultSet[1] == "00") resultSet[0] else value1
        } else {
            value1
        }
    }

    fun formatDateToSpecificDateFormat(
        date: String?,
        convertFormat: String?,
        parseFormat: String?,
    ): String? {
        return try {
            Log.d("DateOfBirthCheck", "DOB $date")
            val date0 = date?.let { SimpleDateFormat(parseFormat, Locale.getDefault()).parse(it) }
            Log.d("DateOfBirthCheck", "Date $date0")
            date0?.let {
                val date1 = SimpleDateFormat(convertFormat, Locale.getDefault()).format(it)
                Log.d("DateOfBirthCheck", "Date1 $date1")
                date1
            }
        } catch (pe: ParseException) {
            null
        }
    }

    fun convertToWithoutEpsilon(value: String?): String? {
        val valueWithoutEpsilon = value?.toBigDecimal()
        return valueWithoutEpsilon?.toPlainString()
    }
}
