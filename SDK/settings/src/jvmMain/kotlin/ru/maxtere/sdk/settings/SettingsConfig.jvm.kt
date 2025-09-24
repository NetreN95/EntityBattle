package ru.maxtere.sdk.settings

import ru.maxtere.sdk.platform.PlatformConfig

actual class SettingsConfig

actual fun SettingsConfig(platformConfig: PlatformConfig): SettingsConfig {
    return SettingsConfig()
}