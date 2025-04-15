package com.example.dweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dweek05a.model.ButtonType
import com.example.dweek05a.model.imageData
import com.example.dweek05a.viewmodel.ImageViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(modifier: Modifier = Modifier, imageViewModel: ImageViewModel = viewModel()) {

    // val imageViewModel: ImageViewModel = viewModel()
    val imageList = imageViewModel.imageList

    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf { //true 인 동안은 안바뀌고 false로 바뀔 때만 바꿔줌.?
            state.firstVisibleItemIndex > 0
        }
    }

    val orientation = LocalConfiguration.current.orientation
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        LazyColumn(
            state = state,
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            itemsIndexed(imageList){ index, imageData->
                when (imageData.buttonType) {
                    ButtonType.ICON -> {
                        ImageWithButton(image = imageData.image) {
                            ButtonWithIcon(likes = imageData.likes) {
                                imageList[index] =
                                    imageData.copy(likes = imageData.likes + 1)
                            }
                        }
                    }

                    ButtonType.BADGE -> {
                        ImageWithButton(image = imageData.image) {
                            ButtonWithBadge(likes = imageData.likes) {
                                imageList[index] =
                                    imageData.copy(likes = imageData.likes + 1)
                            }
                        }
                    }

                    ButtonType.EMOJI -> {
                        ImageWithButton(image = imageData.image) {
                            ButtonWithEmoji(
                                likes = imageData.likes,
                                dislikes = imageData.dislikes,
                                onClickLikes = {
                                    imageList[index] =
                                        imageData.copy(likes = imageData.likes + 1) //copy하는 순간 immutable
                                },
                                onClickDisLikes = {
                                    imageList[index] =
                                        imageData.copy(dislikes = imageData.dislikes + 1) //copy하는 순간 immutable
                                }
                            )
                        }
                    }
                }
            }
        }
        AnimatedVisibility(visible = showButton) {
            ScrollTopButton {
                scope.launch {
                    state.scrollToItem(0)
                }
            }
        }
    } else {
        LazyRow(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            itemsIndexed(imageList){ index, imageData->
                when (imageData.buttonType) {
                    ButtonType.ICON -> {
                        ImageWithButton(image = imageData.image) {
                            ButtonWithIcon(likes = imageData.likes) {
                                imageList[index] =
                                    imageData.copy(likes = imageData.likes + 1)
                            }
                        }
                    }

                    ButtonType.BADGE -> {
                        ImageWithButton(image = imageData.image) {
                            ButtonWithBadge(likes = imageData.likes) {
                                imageList[index] =
                                    imageData.copy(likes = imageData.likes + 1)
                            }
                        }
                    }

                    ButtonType.EMOJI -> {
                        ImageWithButton(image = imageData.image) {
                            ButtonWithEmoji(
                                likes = imageData.likes,
                                dislikes = imageData.dislikes,
                                onClickLikes = {
                                    imageList[index] =
                                        imageData.copy(likes = imageData.likes + 1) //copy하는 순간 immutable
                                },
                                onClickDisLikes = {
                                    imageList[index] =
                                        imageData.copy(dislikes = imageData.dislikes + 1) //copy하는 순간 immutable
                                }
                            )
                        }
                    }
                }
            }
        }
    }




//    var img1State by rememberSaveable(stateSaver = imageData.ImageSaver) {
//        mutableStateOf(
//            imageData(
//                image = ImageUri.ResImage(R.drawable.img1),
//                buttonType = ButtonType.BADGE,
//                likes = 50,
//                dislikes = 10
//            )
//        )
//    }
//
//    var img2State by rememberSaveable(stateSaver = imageData.ImageSaver) {
//        mutableStateOf(
//            imageData(
//                image = ImageUri.ResImage(R.drawable.img2),
//                buttonType = ButtonType.EMOJI,
//                likes = 30,
//                dislikes = 5
//            )
//        )
//    }

//
//    Column {
//        ImageWithButton(image = img1State.image) {
//            ButtonWithBadge(likes = img1State.likes) {
//                img1State = img1State.copy(likes = img1State.likes+1 ) //copy하는 순간 immutable
//            }
//        }
//
//        ImageWithButton(image = img2State.image) {
//            ButtonWithEmoji(
//                likes = img2State.likes,
//                dislikes = img2State.dislikes,
//                onClickLikes = {
//                    img2State = img2State.copy(likes = img2State.likes+1 ) //copy하는 순간 immutable
//                },
//                onClickDisLikes = {
//                    img2State = img2State.copy(likes = img2State.dislikes+1 ) //copy하는 순간 immutable
//                }
//            )
//        }
//    }
}


@Preview
@Composable
private fun MainScreenPrev() {
    MainScreen()

}