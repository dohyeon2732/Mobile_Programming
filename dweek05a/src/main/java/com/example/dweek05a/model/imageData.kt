package com.example.dweek05a.model

import androidx.compose.runtime.saveable.listSaver

data class imageData(
    val image:ImageUri,
    val buttonType: ButtonType = ButtonType.ICON,
    var likes: Int = 0,
    var dislikes : Int = 0
){
    companion object{
        val ImageSaver = listSaver<imageData,Any>(
            save = {item->
                listOf(
                    when(item.image){
                        is ImageUri.ResImage -> item.image.resID
                        is ImageUri.WebImage -> item.image.webUrl
                        else -> {}
                    },
                    item.buttonType.name,
                    item.likes,
                    item.dislikes
                )
            },
            restore = {list->
                val img = list[0]
                val image = when(img){
                    is Int -> ImageUri.ResImage(img)
                    is String -> ImageUri.WebImage(img)
                    else -> throw IllegalArgumentException("타입 오류")
                }
                imageData(
                    image = image,
                    buttonType = ButtonType.valueOf(list[1] as String),
                    likes = list[2] as Int,
                    dislikes = list[3] as Int
                )
            }
        )
    }
}