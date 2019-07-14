package com.example.donate.data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class ChildrenRepo (private val childrenDAO: ChildrenDAO) {


    val allChildren: LiveData<MutableList<Children>> = childrenDAO.getAllChildren()

    @WorkerThread
    fun insert(children: Children){
        childrenDAO.insert(children)
    }
}