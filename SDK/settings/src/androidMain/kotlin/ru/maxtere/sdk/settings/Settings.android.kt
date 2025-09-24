package ru.maxtere.sdk.settings

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

actual fun Settings(settingsConfig: SettingsConfig): Settings {
    return SharedPreferencesSettings(
        settingsConfig.androidContext.getSharedPreferences(
            "AppSettings",
            Context.MODE_PRIVATE
        )
    )
}