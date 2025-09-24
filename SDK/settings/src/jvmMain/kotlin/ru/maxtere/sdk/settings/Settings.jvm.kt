package ru.maxtere.sdk.settings

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import java.util.prefs.Preferences

actual fun Settings(settingsConfig: SettingsConfig): Settings {
    return PreferencesSettings(Preferences.userRoot())
}