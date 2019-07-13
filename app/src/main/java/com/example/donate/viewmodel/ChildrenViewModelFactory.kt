package com.example.donate.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ChildrenViewModelFactory @Inject constructor(private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = ChildrenListViewModel(application)
        return getViewModel(viewModel, modelClass)
    }

    protected fun <T : ViewModel?> getViewModel(viewModel: ViewModel, modelClass: Class<T>): T {
        val result = listOf(viewModel).filterIsInstance(modelClass)
        if (result.size == 1) {
            return result[0]
        } else {
            throw IllegalArgumentException("Failed to cast. Invalid view model factory")
        }
    }
}