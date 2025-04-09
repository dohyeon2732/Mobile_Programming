package com.example.dweek05a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.dweek05a.R

object imageListFactory {
    fun makeImageList() = mutableStateListOf(
        imageData(
            image = ImageUri.ResImage(R.drawable.img1),
            buttonType = ButtonType.BADGE,
            likes = 50
        ),
        imageData(
            image = ImageUri.ResImage(R.drawable.img2),
            buttonType = ButtonType.ICON,
            likes = 100
        ),
        imageData(
            image = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.EMOJI,
            likes = 50,
            dislikes = 10
        ),
        imageData(
            image = ImageUri.ResImage(R.drawable.img1),
            buttonType = ButtonType.BADGE,
            likes = 50
        )

    )

}