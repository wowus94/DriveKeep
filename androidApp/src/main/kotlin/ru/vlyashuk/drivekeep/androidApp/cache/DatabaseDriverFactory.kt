package ru.vlyashuk.drivekeep.androidApp.cache

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import ru.vlyashuk.drivekeep.db.MyDatabase
import ru.vlyashuk.drivekeep.cache.DatabaseDriverFactory

class AndroidDatabaseDriverFactory(private val context: Context) : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(MyDatabase.Schema, context, "launch.db")
    }
}