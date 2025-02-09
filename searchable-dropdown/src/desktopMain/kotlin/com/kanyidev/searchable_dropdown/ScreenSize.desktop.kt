package com.kanyidev.searchable_dropdown

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun getScreenSize(): ScreenSize {
    val size = LocalWindowInfo.current.containerSize
    return ScreenSize(
        width = size.width,
        height = size.height
    )
}