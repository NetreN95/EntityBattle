package ru.maxtere.sdk.platform

actual open class PlatformConfig(
    val onApplicationFinish: () -> Unit = {}
)