package com.kanyidev.searchable_dropdown

import androidx.compose.runtime.Composable


class ScreenSize(
    val width: Int,
    val height: Int,
)

@Composable
expect fun getScreenSize(): ScreenSize
