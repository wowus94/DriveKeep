package ru.vlyashuk.drivekepp

sealed interface Screen {
    data object Home : Screen
    data object Settings : Screen
    data object Favorite : Screen

}