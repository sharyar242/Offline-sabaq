package com.example.offlinesabaq

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*

class Adapter (private val activity: MainActivity): RecyclerView.Adapter<Adapter.ViewHolder>() {


    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        fun populateModel(post: User ,position: Int,activity: MainActivity ){
            itemView.title.text = post.tvTitle
            itemView.setOnLongClickListener {
                activity.onOptionsButtonClick(itemView, position)
                return@setOnLongClickListener true
            }


        }


    }
    var models: MutableList<User> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    //   fun onItemAdded(position: Int){
    //      models.add(position,User("Title ${models.size+1}"))
    //     notifyItemInserted(position)
    //     notifyItemRangeChanged(position,models.size)
    //  }


    fun onItemDeleted(position: Int) {
        models.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position,models.size)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position],position,activity)
    }

    override fun getItemCount(): Int =models.size


}