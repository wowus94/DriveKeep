package ru.vlyashuk.drivekeep

sealed interface Screen {
    data object Home : Screen
    data object Settings : Screen
    data object Vehicle : Screen

}