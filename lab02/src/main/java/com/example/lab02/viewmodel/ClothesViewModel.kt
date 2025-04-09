package com.example.lab02.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.lab02.model.Clothes
import com.example.lab02.model.PartsClothesFactory

class ClothesViewModel : ViewModel(){

    private val _clothesList = PartsClothesFactory.makeParts().toMutableStateList()

    val clothesList : MutableList<Clothes>
        get()=_clothesList
}