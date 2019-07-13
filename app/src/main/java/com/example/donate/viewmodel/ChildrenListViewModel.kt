package com.example.donate.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.donate.data.Children
import com.example.donate.data.ChildrenDatabase
import com.example.donate.data.ChildrenRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class  ChildrenListViewModel @Inject constructor(application: Application): AndroidViewModel(application) {

    @Inject
    lateinit var repo: ChildrenRepo

    val allChildren: LiveData<MutableList<Children>>

    init {
        allChildren = repo.allChildren
    }

    fun insert(children: Children){
        viewModelScope.launch(Dispatchers.IO){
            repo.insert(children)
        }
    }
}