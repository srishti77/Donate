package com.example.donate.di


import android.app.Application
import androidx.room.Room
import com.example.donate.data.ChildrenDAO
import com.example.donate.data.ChildrenDatabase
import com.example.donate.data.ChildrenRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule(val application: Application) {

    @Provides
    @Singleton
    internal fun provideDatabase() : ChildrenDatabase{
        return Room.databaseBuilder(application.applicationContext, ChildrenDatabase::class.java, "children_database")
                .build()
    }


    @Provides
    @Singleton
    internal fun provideChildrenDao(database: ChildrenDatabase): ChildrenDAO {
        return database.childrenDao()
    }

    @Provides
    @Singleton
    internal fun provideChildrenRepository(childrenDAO: ChildrenDAO): ChildrenRepo{
        return ChildrenRepo(childrenDAO)
    }
}