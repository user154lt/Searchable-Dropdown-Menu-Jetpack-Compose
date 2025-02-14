package com.breens.searchableexposeddropdownmenujetpackcompose

import MainScreen
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "SearchableDropdownCompose",
    ) {
        MainScreen()
    }
}