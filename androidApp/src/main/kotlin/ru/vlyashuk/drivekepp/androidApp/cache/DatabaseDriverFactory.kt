package ru.vlyashuk.drivekepp.androidApp.cache

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import ru.vlyashuk.drivekepp.db.MyDatabase
import ru.vlyashuk.drivekepp.cache.DatabaseDriverFactory

class AndroidDatabaseDriverFactory(private val context: Context) : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(MyDatabase.Schema, context, "launch.db")
    }
}