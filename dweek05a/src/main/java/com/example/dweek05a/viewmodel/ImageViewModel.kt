package com.example.dweek05a.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dweek05a.model.imageData
import com.example.dweek05a.model.imageListFactory

class ImageViewModel:ViewModel() {
    private val _imageList = imageListFactory.makeImageList()
    val imageList:MutableList<imageData>
        get()=_imageList
}