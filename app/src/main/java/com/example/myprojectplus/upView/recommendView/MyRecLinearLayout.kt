package com.example.myprojectplus.upView.recommendView

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import kotlin.math.abs

class MyRecLinearLayout @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleId: Int = 0) :
    LinearLayout(context,attrs,defStyleId) {

    private var startX : Int = 0
    private var startY : Int = 0

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        when(ev.action){
            MotionEvent.ACTION_DOWN -> {
                startX = ev.x.toInt()
                startY = ev.y.toInt()
                if ((parent as View).canScrollHorizontally(-1)) {
                    parent.requestDisallowInterceptTouchEvent(true)
                }
            }

            MotionEvent.ACTION_MOVE -> {
                parent.requestDisallowInterceptTouchEvent(true)
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                parent.requestDisallowInterceptTouchEvent(false)
            }
        }
        return super.onInterceptTouchEvent(ev)
    }
}