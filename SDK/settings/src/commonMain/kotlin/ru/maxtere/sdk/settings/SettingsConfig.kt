package ru.maxtere.sdk.settings

import ru.maxtere.sdk.platform.PlatformConfig

expect class SettingsConfig

expect fun SettingsConfig(platformConfig: PlatformConfig): SettingsConfig