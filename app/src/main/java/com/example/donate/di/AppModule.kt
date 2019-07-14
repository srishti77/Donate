package com.example.donate.di

import androidx.room.Room
import com.example.donate.data.ChildrenDAO
import com.example.donate.data.ChildrenDatabase
import com.example.donate.data.ChildrenRepo
import com.example.donate.viewmodel.ChildrenListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


var donateAppModule = module {
    single<ChildrenDatabase> {
        Room.databaseBuilder(
            androidContext(),
            ChildrenDatabase::class.java, "app-database"
        ).build()
    }

    single<ChildrenDAO> {
        get<ChildrenDatabase>().childrenDao()
    }

    single {
        ChildrenRepo(get())
    }

    viewModel {
        ChildrenListViewModel(get())
    }
}