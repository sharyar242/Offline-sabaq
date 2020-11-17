package com.example.offlinesabaq.calenderDialog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.offlinesabaq.R

class DialogAdapter: RecyclerView.Adapter<DialogViewHolder>() {
    var selectedItem: Int = -1
    set(value) {
        field = value
        models[value].isSelected = true
        notifyItemChanged(value)
    }

    var models : List<MyModel> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bg,parent,false)
        return DialogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DialogViewHolder, position: Int) {
        holder.populateModel(models[position], position, this)
    }

    override fun getItemCount(): Int = models.size
}