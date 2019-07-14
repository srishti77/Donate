package com.example.donate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.donate.data.Children
import com.example.donate.viewmodel.ChildrenListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val childrenViewModel: ChildrenListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ChildrenListAdapter(this)
        val recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        childrenViewModel.allChildren.observe(this, Observer{ childrens ->
            childrens?.let {
                adapter.setChildren(childrens)
            }
        })
        insertData()
    }

    private fun insertData() {
        val children = Children("23", "Srishti Gaihre", "12")
        childrenViewModel.insert(children)
        val children2 = Children("34", "Nabin Raj Gaihre", "23")
        childrenViewModel.insert(children2)
    }

}
