package com.example.offlinesabaq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.offlinesabaq.calenderDialog.CalendarDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_edit.*
import kotlinx.android.synthetic.main.item_edit.view.*


class MainActivity : AppCompatActivity() {

    private val adapter = Adapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter =adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        setData()
    }

    private fun setData(){
        val models: MutableList<User> = mutableListOf()
        for (i in 1..12){
            val model = User()
            model.tvTitle = "Title $i"
            models.add(model)
        }
        this.adapter.models = models

    }

     fun onOptionsButtonClick(view: View, position: Int) {
         val menu = PopupMenu(this, view)
         val menuInflater = menu.menuInflater
         menuInflater.inflate(R.menu.menu, menu.menu)
         menu.show()
         menu.setOnMenuItemClickListener {
             when (it.itemId) {
                 R.id.itemAdd -> {
        //            adapter.onItemAdded(position + 1)
         //           return@setOnMenuItemClickListener true
                     val dialog = CalendarDialog(this)
                     dialog.show()
                 }
                 R.id.item_delete -> {
                     adapter.onItemDeleted(position)

                 }
                                  R.id.item_edit -> {
                     val view : View = LayoutInflater.from(parent).inflate(R.layout.item_edit,null )
                     val dialog: AlertDialog = AlertDialog.Builder(this)
                         .setView(view)
                         .create()

                     view.button_edit.setOnClickListener {
                         if (!dialog.editItem.text.isNullOrEmpty()){
                             adapter.models[position].tvTitle = dialog.editItem.toString()
                             adapter.notifyItemChanged(position)
                             dialog.dismiss()
                         }

                     }
                     dialog.show()
                 }
             }
             return@setOnMenuItemClickListener true
         }
         menu.show()
     }



}