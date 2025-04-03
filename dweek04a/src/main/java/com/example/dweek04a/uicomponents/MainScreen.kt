package com.example.dweek04a.uicomponents

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dweek04a.model.Item
import com.example.dweek04a.model.TodoItemFactory
import com.example.dweek04a.model.TodoStatus

@SuppressLint("RememberReturnType")
@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val todoList = remember {
        //mutableStateListOf<Item>()
        TodoItemFactory.makeTodoList()
    }

    var complete by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxSize()) {
        TodoListTitle()
        TodoSwitch(complete) {
            complete = it
        }
        TodoList(todoList,complete, modifier = Modifier.weight(1f))
        TodoItemInput(todoList)
    }
}

@Preview
@Composable
private fun MainScreenPrev() {
    MainScreen()
}