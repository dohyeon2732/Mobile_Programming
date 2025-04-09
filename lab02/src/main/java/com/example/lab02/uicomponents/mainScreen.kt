package com.example.lab02.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab02.viewmodel.ClothesViewModel


@Composable
fun MainScreen(modifier: Modifier = Modifier.fillMaxSize(), clothesViewModel: ClothesViewModel = viewModel()) {

    val clothesList = clothesViewModel.clothesList
    val orientation = LocalConfiguration.current.orientation
    if(orientation ==Configuration.ORIENTATION_PORTRAIT){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ImageArea(clothesList)
            ClothesList(clothesList)
        }
    }else
    {
        Row (
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            ImageArea(clothesList)
            ClothesList(clothesList)
        }
    }




}


@Preview
@Composable
private fun MainScreenPrev() {
    MainScreen()
}