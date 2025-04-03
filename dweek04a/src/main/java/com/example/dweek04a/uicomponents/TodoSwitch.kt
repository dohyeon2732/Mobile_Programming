package com.example.dweek04a.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dweek04a.R

@Composable
fun TodoSwitch(checked : Boolean, modifier: Modifier = Modifier, onCheckedChange: (Boolean)->Unit) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ){
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            text = stringResource(R.string.switch_title),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal
        )

        Switch(
            checked = checked,
            onCheckedChange = { isChecked ->
                onCheckedChange(isChecked)
                println("체크상태 변경 : $isChecked")
            }
        )
    }
}

@Preview
@Composable
private fun TodoSwitchPreview() {
    TodoSwitch(checked = true){}
}