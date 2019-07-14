package com.example.donate.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Children::class], version = 1)
abstract class ChildrenDatabase : RoomDatabase() {

    abstract fun childrenDao(): ChildrenDAO

}