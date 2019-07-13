package com.example.donate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.donate.data.Children
import com.example.donate.di.DaggerAppComponent
import com.example.donate.di.RoomModule
import com.example.donate.viewmodel.ChildrenListViewModel
import com.example.donate.viewmodel.ChildrenViewModelFactory
import dagger.android.AndroidInjection
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

        DaggerAppComponent.builder()
            .applicationInstance(application)
            .roomModule(RoomModule(application))
            .build()

        val adapter = ChildrenListAdapter(this)
        val recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //childrenViewModel =  ViewModelProviders.of(this, viewModelFactory).get(ChildrenListViewModel::class.java)
        val children = Children("23", "Srishti Gaihre", "12")
        childrenViewModel?.insert(children)

        childrenViewModel?.allChildren?.observe(this, Observer{ childrens ->
            childrens?.let {
                adapter.setChildren(childrens)
            }
        })

    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}
