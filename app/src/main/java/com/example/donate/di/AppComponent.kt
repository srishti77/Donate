package com.example.donate.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [AndroidSupportInjectionModule::class,  ActivityBuilder::class, RoomModule::class, MainActivityModule::class]
)
@Singleton
interface AppComponent {


    fun inject(application: DonateApplication)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun applicationInstance(application: Application): Builder

        fun build(): AppComponent

        fun roomModule(roomModule: RoomModule): Builder
    }
}