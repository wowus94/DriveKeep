package ru.vlyashuk.drivekeep.androidApp

import org.koin.dsl.module
import ru.vlyashuk.drivekeep.androidApp.cache.AndroidDatabaseDriverFactory
import ru.vlyashuk.drivekeep.cache.DatabaseDriverFactory

val appModule = module {
    single<DatabaseDriverFactory> { AndroidDatabaseDriverFactory(get()) }
}