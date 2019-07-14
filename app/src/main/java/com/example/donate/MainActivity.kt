package com.example.donate

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.donate.data.Children
import com.example.donate.viewmodel.ChildrenListViewModel
import com.example.donate.viewmodel.ChildrenViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ChildrenViewModelFactory

    @Inject
    lateinit var childrenViewModel: ChildrenListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ChildrenListAdapter(this)
        val recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        childrenViewModel.allChildren.observe(this, Observer { childrens ->
            childrens?.let {
                adapter.setChildren(childrens)
            }
        })

        insertIntoDatabase()
    }

    private fun insertIntoDatabase() {
        val children = Children("23", "Srishti Gaihre", "12")
        childrenViewModel.insert(children)
    }
}
