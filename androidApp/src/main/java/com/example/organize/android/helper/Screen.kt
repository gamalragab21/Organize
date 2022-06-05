package com.example.organize.android.helper

sealed class Screen(val title: String) {
    object TimeZonesScreen : Screen("Timezones")
    object FindTimeScreen : Screen("Find Time")
}