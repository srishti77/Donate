package com.example.donate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.donate.data.Children

class ChildrenListAdapter internal constructor(context: Context) : RecyclerView.Adapter<ChildrenListAdapter.ChildrenViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var childrens = mutableListOf<Children>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildrenViewHolder {
        val item = inflater.inflate(R.layout.list_element, parent,false)
        return ChildrenViewHolder(item)
    }

    override fun getItemCount(): Int =
        childrens.size


    override fun onBindViewHolder(holder: ChildrenViewHolder, position: Int) {
        val current = childrens[position]
        holder.childrenName.text = current.name
    }

    internal fun setChildren(children: MutableList<Children>){
        this.childrens = children
        notifyDataSetChanged()
    }

    internal fun addChildren(children: Children){
        childrens.add(children)
    }
    inner class ChildrenViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val childrenName: TextView = itemView.findViewById(R.id.name)
    }


}