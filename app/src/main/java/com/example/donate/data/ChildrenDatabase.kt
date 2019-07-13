package com.example.donate.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Children::class], version = 1)
abstract class ChildrenDatabase : RoomDatabase() {

    abstract fun childrenDao(): ChildrenDAO

    companion object {
        @Volatile
        private var instance: ChildrenDatabase? = null

        fun getDatabase(context: Context, coroutineScope: CoroutineScope): ChildrenDatabase {
            val tempInstance = instance

            if (tempInstance != null)
                return tempInstance

            synchronized(this) {
                val inst = Room.databaseBuilder(
                    context.applicationContext,
                    ChildrenDatabase::class.java,
                    "Children_Database")
                    .addCallback(ChildrenDatabaseCallback(coroutineScope))
                    .build()

                instance = inst
                return inst

            }
        }
    }

    class ChildrenDatabaseCallback(private val scope: CoroutineScope) :
        RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)

            instance?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.childrenDao())
                }
            }
        }

        private fun populateDatabase(childrenDao: ChildrenDAO) {
            childrenDao.deleteAll()
            val children1 = Children("123", "Priya Kumari", "12")
            childrenDao.insert(children1)
            val children2 = Children("124", "Raj Rizal", "13")
            childrenDao.insert(children2)
            val children3 = Children("125", "Nisha Aryal", "13")
            childrenDao.insert(children3)
        }
    }
}