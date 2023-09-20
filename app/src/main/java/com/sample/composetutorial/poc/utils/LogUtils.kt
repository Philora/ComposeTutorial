package com.sample.composetutorial.poc.utils

import android.util.Log
import com.google.firebase.BuildConfig

object LogUtils {
    /**
     * Logs a string to the console using the source object's name as the log tag at the verbose
     * level. If the source object is null, the default tag is used.
     *
     * @param tag
     * @param message
     */
    @JvmStatic
    fun debug(tag: String?, message: String?) {
        if (BuildConfig.DEBUG && message != null) {
            Log.d(tag, message)
        }
    }

    /**
     * Logs a string to the console using the source object's name as the log tag at the verbose
     * level. If the source object is null, the default tag is used.
     *
     * @param tag
     * @param message
     */
    @JvmStatic
    fun info(tag: String?, message: String?) {
        if (BuildConfig.DEBUG && message != null) {
            Log.i(tag, message)
        }
    }

    /**
     * Logs a string to the console using the source object's name as the log tag at the verbose
     * level. If the source object is null, the default tag is used.
     *
     * @param tag
     * @param message
     */
    @JvmStatic
    fun error(tag: String?, message: String?) {
        if (BuildConfig.DEBUG && message != null) {
            Log.e(tag, message)
        }
    }

    /**
     * Logs a string to the console using the source object's name as the log tag at the verbose
     * level. If the source object is null, the default tag is used.
     *
     * @param tag
     * @param message
     */
    fun verbose(tag: String?, message: String?) {
        if (BuildConfig.DEBUG && message != null) {
            Log.v(tag, message)
        }
    }
}