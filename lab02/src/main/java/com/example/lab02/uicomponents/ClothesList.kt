package com.example.lab02.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab02.model.Clothes
import com.example.lab02.model.PartsClothesFactory

@Composable
fun ClothesList(clothesList: MutableList<Clothes>, modifier: Modifier = Modifier) {

    Column {
        for (i in 0 until clothesList.size step 2) {
            Row {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PartsCheckbox(checked = true) { checked ->

                    }
                    PartsText(cloth = clothesList.get(i))
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PartsCheckbox(checked = true) { checked ->

                    }
                    PartsText(cloth = clothesList.get(i+1))
                }
            }
        }
    }
}

@Preview
@Composable
private fun ClothesListPrev() {
    ClothesList(PartsClothesFactory.makeParts())
}