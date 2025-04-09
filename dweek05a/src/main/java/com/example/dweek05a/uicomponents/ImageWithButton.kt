package com.example.dweek05a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.dweek05a.model.ImageUri


@Composable
fun ImageWithButton(
    image: ImageUri,
    modifier: Modifier = Modifier,
    button: @Composable () -> Unit
) {
    val img = when(image){
        is ImageUri.ResImage -> image.resID
        is ImageUri.WebImage -> image.webUrl
    }

    Column(
        //modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = img,
            contentDescription = "이미지",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        button()
    }

}




@Composable
fun ImageWithButton(
    image: String,
    modifier: Modifier = Modifier,
    button: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = image,
            contentDescription = "이미지",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        button()
    }

}


@Composable
fun ImageWithButton(
    image: Int,
    modifier: Modifier = Modifier,
    button: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = image,
            contentDescription = "이미지",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        button()
    }

}

@Preview
@Composable
private fun ImageWithButtonPreview() {
    var likes by remember { mutableStateOf(0) }
    var dislikes by remember { mutableStateOf(0) }

    ImageWithButton(image = "data:image/jpeg;base64,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",
    ) {
        ButtonWithEmoji(likes, dislikes, { likes++ }, { dislikes++ })
    }
}