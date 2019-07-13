package com.example.donate.di

import com.example.donate.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract  class ActivityBuilder {

    @MainActivityScope
    @ContributesAndroidInjector(
        modules = [MainActivityModule::class]
    )
    abstract fun bindMainActivity(): MainActivity
}