package com.jayden.ifkakaoclone.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.widget.NestedScrollView

class StickyNestedScrollView : NestedScrollView, ViewTreeObserver.OnGlobalLayoutListener {
    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attr: AttributeSet?) : this(context, attr, 0)
    constructor(context: Context, attr: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attr,
        defStyleAttr
    ) {
        overScrollMode = OVER_SCROLL_NEVER
        viewTreeObserver.addOnGlobalLayoutListener(this)
    }

    private var headerInitPosition = 0f

    var header: View? = null
        set(value) {
            field = value?.apply {
                translationZ = 1f
            }
        }

    override fun onGlobalLayout() {
        headerInitPosition = header?.top?.toFloat() ?: 0f
    }

    // ScrollView -> NestedScrollView 로 이전하면서
    // onScrollChanged 가 이전에 비해 많이 불려서
    // translationY 반영 타이밍 때문에 깜빡임이 존재하는 건가.. 좀 더 알아봐야 할 듯
    override fun onScrollChanged(scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
        super.onScrollChanged(scrollX, scrollY, oldScrollX, oldScrollY)

        if (scrollY > headerInitPosition) {
            fixHeader(scrollY - headerInitPosition)
        } else {
            releaseHeader()
        }
    }

    private fun fixHeader(position: Float) {
        header?.translationY = position
    }

    private fun releaseHeader() {
        header?.translationY = 0f
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewTreeObserver.removeOnGlobalLayoutListener(this)
        header = null
    }
}