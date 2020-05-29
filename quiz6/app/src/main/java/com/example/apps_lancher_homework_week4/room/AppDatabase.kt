package com.example.apps_lancher_homework_week4.room

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.apps_lancher_homework_week4.MainAppContext


@Database(entities = arrayOf(ItemsModel::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemsModelDao(): ItemsDao



}
val myDB = Room.databaseBuilder(
    MainAppContext.applicationContext(),
    AppDatabase::class.java, "database-users"
).build()