package com.example.lab02.model

import androidx.compose.runtime.mutableStateListOf

object PartsClothesFactory {
    fun makeParts()= mutableStateListOf(
        Clothes("arms",false),
        Clothes("ears",false),
        Clothes("eyebrows",false),
        Clothes("eyes",false),
        Clothes("glassess",false),
        Clothes("hat",false),
        Clothes("mouth",false),
        Clothes("mustache",false),
        Clothes("nose",false),
        Clothes("shoes",false),

    )
}