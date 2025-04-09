package com.example.lab02.uicomponents

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab02.model.Clothes

@Composable
fun PartsText(cloth : Clothes , modifier: Modifier = Modifier) {
    Text(
        text = "  " + cloth.title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.width(100.dp)
    )
}

@Preview
@Composable
private fun PartsTextPrev() {
    PartsText(Clothes("ears",true))
}