package com.example.offlinesabaq.calenderDialog

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_bg.view.*

class DialogViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {

    fun populateModel(model: MyModel, index: Int, adapter: DialogAdapter){
        itemView.tvNumber.text = model.number.toString()
        if (model.isSelected){
            itemView.ivBg.visibility = View.VISIBLE
        } else {
            itemView.ivBg.visibility = View.INVISIBLE
        }
        itemView.setOnClickListener {
            adapter.selectedItem = index
        }
    }


}