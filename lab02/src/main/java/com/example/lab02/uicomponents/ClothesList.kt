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
fun ClothesList(clothesList:MutableList<Clothes>, modifier: Modifier = Modifier) {

    Column {
        for (i in 0 until clothesList.size step 2) {
            Row {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PartsCheckbox(checked = clothesList[i].wear) { checked ->
                        println("checkbox clicked : ${clothesList[i].title}, state: ${if (checked) "checked" else "unchecked"}")
                        clothesList[i] = clothesList[i].copy(
                            wear = if(checked) true else false
                        )
                    }
                    PartsText(cloth = clothesList.get(i))
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PartsCheckbox(checked = clothesList[i+1].wear) { checked ->
                        println("checkbox clicked : ${clothesList[i+1].title}, state: ${if (checked) "checked" else "unchecked"}")
                        clothesList[i+1] = clothesList[i+1].copy(
                            wear = if(checked) true else false
                        )

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