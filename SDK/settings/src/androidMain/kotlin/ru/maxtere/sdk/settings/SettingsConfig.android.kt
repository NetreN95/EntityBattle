package ru.maxtere.sdk.settings

import android.content.Context
import ru.maxtere.sdk.platform.PlatformConfig

actual class SettingsConfig(
    val androidContext: Context
)

actual fun SettingsConfig(platformConfig: PlatformConfig): SettingsConfig {
    return SettingsConfig(androidContext = platformConfig.androidContext)
}