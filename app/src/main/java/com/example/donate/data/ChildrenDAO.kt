package com.example.donate.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ChildrenDAO {

    @Query("SELECT * FROM Children")
    fun getAllChildren(): LiveData<MutableList<Children>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(children: Children)

    @Query("DELETE FROM Children")
    fun deleteAll()
}