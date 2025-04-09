package com.example.dweek05a.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.dweek05a.model.ButtonType
import com.example.dweek05a.model.imageData

@Composable
fun ImageList(
    modifier: Modifier = Modifier,
    imageList: MutableList<imageData>
) {
    imageList.forEachIndexed { index, imageData ->
        when (imageData.buttonType) {
            ButtonType.ICON -> {
                ImageWithButton(image = imageData.image) {
                    ButtonWithIcon(likes = imageData.likes) {
                        imageList[index] =
                            imageData.copy(likes = imageData.likes + 1)
                    }
                }
            }

            ButtonType.BADGE -> {
                ImageWithButton(image = imageData.image) {
                    ButtonWithBadge(likes = imageData.likes) {
                        imageList[index] =
                            imageData.copy(likes = imageData.likes + 1)
                    }
                }
            }

            ButtonType.EMOJI -> {
                ImageWithButton(image = imageData.image) {
                    ButtonWithEmoji(
                        likes = imageData.likes,
                        dislikes = imageData.dislikes,
                        onClickLikes = {
                            imageList[index] =
                                imageData.copy(likes = imageData.likes + 1) //copy하는 순간 immutable
                        },
                        onClickDisLikes = {
                            imageList[index] =
                                imageData.copy(likes = imageData.dislikes + 1) //copy하는 순간 immutable
                        }
                    )
                }
            }
        }
    }
}