package com.example.donate.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.donate.data.ChildrenRepo
import javax.inject.Inject

class ChildrenViewModelFactory @Inject constructor(private val repo: ChildrenRepo) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = ChildrenListViewModel(repo)
        return getViewModel(viewModel, modelClass)
    }

    private fun <T : ViewModel?> getViewModel(viewModel: ViewModel, modelClass: Class<T>): T {
        val result = listOf(viewModel).filterIsInstance(modelClass)
        if (result.size == 1) {
            return result[0]
        } else {
            throw IllegalArgumentException("Failed to cast. Invalid view model factory")
        }
    }
}