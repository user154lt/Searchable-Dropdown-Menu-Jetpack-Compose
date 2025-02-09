package com.kanyidev.searchable_dropdown

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
actual fun getScreenSize() = ScreenSize(
    width = LocalConfiguration.current.screenWidthDp,
    height = LocalConfiguration.current.screenHeightDp,
)