package com.example.donate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donate.data.Children
import com.example.donate.data.ChildrenRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class  ChildrenListViewModel(val repo: ChildrenRepo): ViewModel() {


    val allChildren: LiveData<MutableList<Children>> = repo.allChildren

    fun insert(children: Children){
        viewModelScope.launch(Dispatchers.IO){
            repo.insert(children)
        }
    }
}