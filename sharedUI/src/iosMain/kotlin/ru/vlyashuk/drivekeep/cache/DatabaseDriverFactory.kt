package ru.vlyashuk.drivekeep.cache

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import ru.vlyashuk.drivekepp.cache.DatabaseDriverFactory
import ru.vlyashuk.drivekepp.db.MyDatabase

class IOSDatabaseDriverFactory : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(MyDatabase.Schema, "launch.db")
    }
}