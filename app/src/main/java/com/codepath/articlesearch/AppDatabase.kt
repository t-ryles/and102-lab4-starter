package com.codepath.articlesearch

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
// 1: class must be annotated with a @Database annotation
@Database(entities = [ArticleEntity::class], version = 1)
// 2: class must be an abstract class that extends RoomDatabase
abstract class AppDatabase : RoomDatabase() {

    // 3: each DAO class, the database class must define an abstract method
    // that has zero arguments and returns an instance of the DAO class.
    abstract fun articleDao(): ArticleDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "Articles-db"
            ).build()
    }
}