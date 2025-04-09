package com.example.lab02.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab02.R
import com.example.lab02.model.Clothes
import com.example.lab02.model.PartsClothesFactory

@Composable
fun ImageArea(clothesList : MutableList<Clothes>, modifier: Modifier = Modifier) {
    Box(){
        Image(
            painter = painterResource(id = R.drawable.body),
            contentDescription = stringResource(id = R.string.body)
        )
        clothesList.forEachIndexed { index, clothes ->

            if(clothes.wear)
            Image(
                painter = painterResource(id = R.drawable.arms),
                contentDescription = stringResource(id = R.string.arms)
            )
            Image(
                painter = painterResource(id = R.drawable.ears),
                contentDescription = stringResource(id = R.string.ears)
            )
            Image(
                painter = painterResource(id = R.drawable.eyebrows),
                contentDescription = stringResource(id = R.string.eyebrows)
            )
            Image(
                painter = painterResource(id = R.drawable.eyes),
                contentDescription = stringResource(id = R.string.eyes)
            )
            Image(
                painter = painterResource(id = R.drawable.glasses),
                contentDescription = stringResource(id = R.string.glasses)
            )
            Image(
                painter = painterResource(id = R.drawable.hat),
                contentDescription = stringResource(id = R.string.hat)
            )
            Image(
                painter = painterResource(id = R.drawable.mouth),
                contentDescription = stringResource(id = R.string.mouth)
            )
            Image(
                painter = painterResource(id = R.drawable.mustache),
                contentDescription = stringResource(id = R.string.mustache)
            )
            Image(
                painter = painterResource(id = R.drawable.nose),
                contentDescription = stringResource(id = R.string.nose)
            )
            Image(
                painter = painterResource(id = R.drawable.shoes),
                contentDescription = stringResource(id = R.string.shoes)
            )



        }

    }


}

@Preview
@Composable
private fun ImageAreaPrev() {
    ImageArea(PartsClothesFactory.makeParts())
}