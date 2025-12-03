package com.example.nefis

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter

class Card: Presenter(){
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val card = ImageCardView(parent.context)
        card.isFocusable = true
        card.isFocusableInTouchMode = true

        // Create a play-overlay ImageView centered on the card
        val playOverlay = ImageView(parent.context).apply {
            // use framework play icon (safe fallback)
            setImageResource(android.R.drawable.ic_media_play)
            alpha = 0.85f
            isClickable = false
            isFocusable = false
        }

        val lp = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        // add overlay to the card; ImageCardView is a FrameLayout so this will sit on top
        card.addView(playOverlay, lp)

        // Focus animation: scale up slightly on focus
        card.onFocusChangeListener = View.OnFocusChangeListener { v: View, hasFocus: Boolean ->
            val scale = if (hasFocus) 1.05f else 1.0f
            v.animate().scaleX(scale).scaleY(scale).setDuration(180).setInterpolator(DecelerateInterpolator()).start()
        }

        return ViewHolder(card)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
        val video = item as Video
        val card = viewHolder.view as ImageCardView

        // Square poster look
        card.titleText = video.title
        // Mostrar el subtítulo y la descripción en la tarjeta de inicio
        // contentText puede contener varias líneas; primero subtítulo luego descripción
        card.contentText = "${video.subtitle}\n${video.description}"
        card.setMainImageDimensions(360, 360)

        // set main image from resources
        try {
            val drawable = card.context.resources.getDrawable(video.image, null)
            card.mainImage = drawable
        } catch (e: Exception) {
            // fallback to background resource if drawable load fails
            card.setBackgroundResource(video.image)
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        val card = viewHolder.view as ImageCardView
        card.mainImage = null
    }

}