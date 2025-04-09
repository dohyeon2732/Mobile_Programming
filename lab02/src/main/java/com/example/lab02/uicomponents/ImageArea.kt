package com.example.lab02.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab02.R
import com.example.lab02.model.Clothes
import com.example.lab02.model.PartsClothesFactory

@Composable
fun ImageArea(clothesList : MutableList<Clothes>, modifier: Modifier = Modifier) {

    val stringres : List<String> = listOf(
        stringResource(id = R.string.arms),
        stringResource(id = R.string.ears),
        stringResource(id = R.string.eyebrows),
        stringResource(id = R.string.eyes),
        stringResource(id = R.string.glasses),
        stringResource(id = R.string.hat),
        stringResource(id = R.string.mouth),
        stringResource(id = R.string.mustache),
        stringResource(id = R.string.nose),
        stringResource(id = R.string.shoes)
        )

    val drawableres : List<Painter> = listOf(
        painterResource(id = R.drawable.arms),
        painterResource(id = R.drawable.ears),
        painterResource(id = R.drawable.eyebrows),
        painterResource(id = R.drawable.eyes),
        painterResource(id = R.drawable.glasses),
        painterResource(id = R.drawable.hat),
        painterResource(id = R.drawable.mouth),
        painterResource(id = R.drawable.mustache),
        painterResource(id = R.drawable.nose),
        painterResource(id = R.drawable.shoes)
        )

    Box(
        modifier = Modifier.size(300.dp,300.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.body),
            contentDescription = stringResource(id = R.string.body),
            modifier = Modifier.size(300.dp,300.dp)
        )
        clothesList.forEachIndexed { index, clothes ->
            if(clothes.wear){
                Image(
                    painter =drawableres.get(index),
                    contentDescription = stringres.get(index),
                    modifier = Modifier.size(300.dp,300.dp)
                )
            }
        }

    }


}

@Preview
@Composable
private fun ImageAreaPrev() {
    ImageArea(PartsClothesFactory.makeParts())
}