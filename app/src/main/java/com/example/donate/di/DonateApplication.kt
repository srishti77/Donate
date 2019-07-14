package com.example.donate.di

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class DonateApplication : Application(), HasActivityInjector {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()
        appComponent =
            DaggerAppComponent.builder().applicationInstance(this).roomModule(RoomModule(this))
                .build()
        appComponent.inject(this)

    }

    fun getInstance(): AppComponent {
        return appComponent
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}