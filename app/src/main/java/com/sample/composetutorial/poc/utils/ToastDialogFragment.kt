package com.sample.composetutorial.poc.utils

import android.R.style
import android.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager.LayoutParams
import android.widget.TextView
import com.sample.composetutorial.R

/**
 * A dialog which uses to Toast Dialog
 */
class ToastDialogFragment : DialogFragment() {

    private var sessionTimeOutText: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Do not create a new Fragment when the Activity is re-created such as orientation changes.
        retainInstance = true
        isCancelable = true
        setStyle(STYLE_NORMAL, style.Theme_Material_Dialog_NoActionBar)
        sessionTimeOutText = getString(R.string.session_timout_msg)
        if (arguments != null && !TextUtils.isEmpty(arguments.getString("session_timeout_text"))) {
            sessionTimeOutText = arguments.getString("session_timeout_text")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        dialog.setTitle(getString(R.string.sign_in))
        val v = inflater.inflate(R.layout.toast_dialog_container, container, false)
        val textView = v.findViewById<TextView>(R.id.toast_text)
        textView.text = sessionTimeOutText
        if (dialog != null && dialog.window != null) {
            dialog.window!!.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM)
            val p = dialog.window!!.attributes
            p.width = ViewGroup.LayoutParams.MATCH_PARENT
            p.softInputMode = LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE
            dialog.window!!.attributes = p
        }
        return v
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        //AppUtils.clearSession();
    }

    companion object {
        fun newInstance(sessionTimeOutText: String?): ToastDialogFragment {
            val f = ToastDialogFragment()
            val args = Bundle()
            args.putString("session_timeout_text", sessionTimeOutText)
            f.arguments = args
            return f
        }
    }
}