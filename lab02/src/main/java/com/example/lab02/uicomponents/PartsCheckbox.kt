package com.example.lab02.uicomponents

import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PartsCheckbox(checked: Boolean, modifier: Modifier = Modifier, onCheckedChange: (Boolean)-> Unit) {
    Checkbox(checked = checked,
        onCheckedChange = { isChecked ->
            onCheckedChange(isChecked)
        })
}

@Preview
@Composable
private fun PartsCheckbox() {
    PartsCheckbox(checked = true){}
}