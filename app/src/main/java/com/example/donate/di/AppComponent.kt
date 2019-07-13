package com.example.donate.di

import android.app.Application
import com.example.donate.data.ChildrenRepo
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [RoomModule::class]
)
@Singleton
interface AppComponent {


    fun inject(mainApplication: Application)

    fun getRepo(): ChildrenRepo

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun applicationInstance(application: Application): Builder

        fun build(): AppComponent
        //@BindsInstance
        fun roomModule(roomModule: RoomModule): Builder
    }
}