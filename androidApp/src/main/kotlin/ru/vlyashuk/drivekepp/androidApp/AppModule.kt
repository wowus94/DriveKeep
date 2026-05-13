package ru.vlyashuk.drivekepp.androidApp

import org.koin.dsl.module
import ru.vlyashuk.drivekepp.androidApp.cache.AndroidDatabaseDriverFactory
import ru.vlyashuk.drivekepp.cache.DatabaseDriverFactory

val appModule = module {
    single<DatabaseDriverFactory> { AndroidDatabaseDriverFactory(get()) }
}