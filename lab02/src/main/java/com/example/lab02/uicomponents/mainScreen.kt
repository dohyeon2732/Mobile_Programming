package com.example.lab02.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab02.model.PartsClothesFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var clothesList = remember {
        PartsClothesFactory.makeParts()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageArea(clothesList)
        ClothesList(clothesList)
    }
}


@Preview
@Composable
private fun MainScreenPrev() {
    MainScreen()
}