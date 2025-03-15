package com.verimsolution.tailwind.internal

import androidx.compose.ui.text.PlatformTextStyle


private const val DefaultIncludeFontPadding = false

@Suppress("DEPRECATION")
private val DefaultPlatformTextStyle = PlatformTextStyle(includeFontPadding = DefaultIncludeFontPadding)

internal fun defaultPlatformTextStyle(): PlatformTextStyle? = DefaultPlatformTextStyle
