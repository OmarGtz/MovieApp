package com.example.movieapp.presentation.components

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import androidx.core.widget.ImageViewCompat
import com.example.movieapp.R
import com.google.android.material.card.MaterialCardView

class BannerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.bannerViewStyle
) : MaterialCardView(context, attrs, defStyleAttr) {


    var status = BannerStatusView.SUCCESS
        set(value) {
            if (value == field) return
            field = value
            val drawable = ContextCompat.getDrawable(context, value.drawable)
            icon.setImageDrawable(drawable)
            val color = ContextCompat.getColor(context, value.textColor)
            titleTextView.setTextColor(color)
            subtitleTextView.setTextColor(color)
            ImageViewCompat.setImageTintList(icon, ColorStateList.valueOf(color))
            refreshDrawableState()
        }

    private val icon: ImageView by lazy { findViewById(R.id.icon) }

    var titleText: String = ""
        set(value) {
            if (value.isNotEmpty()) {
                field = value
                titleTextView.text = value
            }
        }

    var subtitleText: String = ""
        set(value) {
            if (value.isNotEmpty()) {
                field = value
                subtitleTextView.text = value
            }
        }

    private val titleTextView: TextView by lazy {
        findViewById(R.id.title)
    }

    private val subtitleTextView: TextView by lazy {
        findViewById(R.id.subtitle)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.component_banner_view, this, true)
        context.withStyledAttributes(
            attrs,
            R.styleable.BannerView,
            defStyleAttr,
            R.style.MovieApp_Widget_BannerView
        ) {
            titleText = getString(R.styleable.BannerView_title) ?: ""
            subtitleText = getString(R.styleable.BannerView_subtitle) ?: ""
            status = when {
                getBoolean(R.styleable.BannerView_state_success, false) -> {
                    BannerStatusView.SUCCESS
                }
                getBoolean(R.styleable.BannerView_state_warning, false) -> {
                    BannerStatusView.WARNING
                }
                getBoolean(R.styleable.BannerView_state_error, false) -> {
                    BannerStatusView.ERROR
                }
                else -> {
                    BannerStatusView.SUCCESS
                }
            }
        }
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        @Suppress("SENSELESS_COMPARISON")
        if (status == null) return super.onCreateDrawableState(extraSpace)
        val drawableState = super.onCreateDrawableState(extraSpace + 1)
        mergeDrawableStates(drawableState, status.state)
        return drawableState
    }
}

enum class BannerStatusView(
    val state: IntArray,
    @DrawableRes val drawable: Int,
    @ColorRes val textColor: Int
) {
    WARNING(intArrayOf(R.attr.state_warning), R.drawable.estrellita, R.color.black),
    SUCCESS(intArrayOf(R.attr.state_success), R.drawable.estrellita, R.color.white),
    ERROR(intArrayOf(R.attr.state_error), R.drawable.ic_home, R.color.white)
}


