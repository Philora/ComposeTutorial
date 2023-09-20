package com.sample.composetutorial.poc.utils

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.os.Handler
import android.os.Handler.Callback
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout.LayoutParams
import android.widget.PopupWindow

class ToolTipWindow(private val ctx: Context, layoutID: Int) {
    private var tipWindow: PopupWindow? = null
    private val contentView: View
    private val inflater: LayoutInflater
    fun showToolTip(anchor: View) {
        tipWindow!!.height = LayoutParams.WRAP_CONTENT
        tipWindow!!.width = LayoutParams.MATCH_PARENT

//        LinearLayout.LayoutParams parm1=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParam s.WRAP_CONTENT);
//        parm1.setMargins(20, 20, 0, 0);
//        tipWindow.setLayoutParams(parm1);
        tipWindow!!.isOutsideTouchable = true
        tipWindow!!.isTouchable = true
        tipWindow!!.isFocusable = true
        tipWindow!!.setBackgroundDrawable(BitmapDrawable())
        tipWindow!!.showAtLocation(contentView, Gravity.NO_GRAVITY, 0, 0)
        tipWindow!!.contentView = contentView
        val screen_pos = IntArray(2)
        // Get location of anchor view on screen
        anchor.getLocationOnScreen(screen_pos)

        // Get rect for anchor view
        val anchor_rect = Rect(
            screen_pos[0], screen_pos[1], screen_pos[0]
                    + anchor.width, screen_pos[1] + anchor.height
        )

        // Call view measure to calculate how big your view should be.
        contentView.measure(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        val contentViewWidth = contentView.measuredWidth
        // In this case , i dont need much calculation for x and y position of
        // tooltip
        // For cases if anchor is near screen border, you need to take care of
        // direction as well
        // to show left, right, above or below of anchor view
        val position_x = anchor_rect.centerX() - contentViewWidth / 2
        val position_y = anchor_rect.bottom - anchor_rect.height() / 2
        tipWindow!!.showAtLocation(anchor, Gravity.NO_GRAVITY, position_x, position_y)

        // send message to handler to dismiss tipWindow after X milliseconds
//        handler.sendEmptyMessageDelayed(MSG_DISMISS_TOOLTIP, 4000);//Uncomment to dismiss tooltip after some duration
    }

    val isTooltipShown: Boolean
        get() = tipWindow != null && tipWindow!!.isShowing

    fun dismissTooltip() {
        if (tipWindow != null && tipWindow!!.isShowing) tipWindow!!.dismiss()
    }

    private val handler = Handler(Callback { msg ->
        when (msg.what) {
            MSG_DISMISS_TOOLTIP -> if (tipWindow != null && tipWindow!!.isShowing) tipWindow!!.dismiss()
        }
        false
    })

    companion object {
        private const val MSG_DISMISS_TOOLTIP = 100
    }

    init {
        tipWindow = PopupWindow(ctx)
        inflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        contentView = inflater.inflate(layoutID, null)
    }
}