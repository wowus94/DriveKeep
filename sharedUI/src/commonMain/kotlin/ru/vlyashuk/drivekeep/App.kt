package ru.vlyashuk.drivekeep

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import drivekeep.sharedui.generated.resources.Res
import drivekeep.sharedui.generated.resources.ic_book
import drivekeep.sharedui.generated.resources.ic_home
import drivekeep.sharedui.generated.resources.ic_settings
import org.jetbrains.compose.resources.vectorResource
import ru.vlyashuk.drivekeep.Screen.Home
import ru.vlyashuk.drivekeep.theme.AppTheme
import ru.vlyashuk.drivekeep.ui.HomeScreen

@Composable
fun App(onThemeChanged: @Composable (isDark: Boolean) -> Unit = {}) = AppTheme(onThemeChanged) {

    val backStack = remember {
        mutableStateListOf<Screen>(Home)
    }

    Scaffold(
        bottomBar = {
            BottomBar(
                current = backStack.last(),
                onNavigate = { screen ->
                    if (backStack.last() != screen) {
                        backStack.add(screen)
                    }
                }
            )
        }
    ) { padding ->

        NavDisplay(
            backStack = backStack,
            onBack = {
                backStack.removeLastOrNull()
            },
            modifier = Modifier.padding(padding),
            entryProvider = { key ->

                when (key) {

                    is Home -> NavEntry(key) {
                        HomeScreen()
                    }

                    is Screen.Settings -> NavEntry(key) {
                        SettingsScreen()
                    }

                    is Screen.Vehicle -> NavEntry(key) {
                        VehicleScreen()
                    }
                }
            }
        )
    }
}

@Composable
fun BottomBar(
    current: Screen,
    onNavigate: (Screen) -> Unit
) {
    NavigationBar {

        NavigationBarItem(
            selected = current is Home,
            onClick = { onNavigate(Home) },
            icon = {
                Icon(
                    vectorResource(Res.drawable.ic_home), null
                )
            },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = current is Screen.Vehicle,
            onClick = { onNavigate(Screen.Vehicle) },
            icon = {
                Icon(
                    vectorResource(Res.drawable.ic_book), null
                )
            },
            label = { Text("Vehicle") }
        )

        NavigationBarItem(
            selected = current is Screen.Settings,
            onClick = { onNavigate(Screen.Settings) },
            icon = {
                Icon(
                    vectorResource(Res.drawable.ic_settings), null
                )
            },
            label = { Text("Settings") }
        )
    }
}