package com.example.lab02.model

import androidx.compose.runtime.mutableStateListOf

object PartsClothesFactory {
    fun makeParts()= mutableStateListOf(
        Clothes("arms",true),
        Clothes("ears",true),
        Clothes("eyebrows",true),
        Clothes("eyes",true),
        Clothes("glassess",true),
        Clothes("hat",true),
        Clothes("mouth",true),
        Clothes("mustache",true),
        Clothes("nose",true),
        Clothes("shoes",true),

    )
}