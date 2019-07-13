package com.example.donate.di

import android.app.Application
import androidx.lifecycle.ViewModelProviders
import com.example.donate.MainActivity
import com.example.donate.viewmodel.ChildrenListViewModel
import com.example.donate.viewmodel.ChildrenViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideViewModelFactory(application: Application): ChildrenViewModelFactory{
        return ChildrenViewModelFactory(application)
    }

    @Provides
    fun providesViewModel(
        mainActivity: MainActivity,
        childrenViewModelFactory: ChildrenViewModelFactory): ChildrenListViewModel{
        return ViewModelProviders.of(mainActivity, childrenViewModelFactory)
            .get(ChildrenListViewModel::class.java)
    }
}