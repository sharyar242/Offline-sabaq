package com.example.offlinesabaq.calenderDialog

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.offlinesabaq.R
import kotlinx.android.synthetic.main.activity_main.*

class CalendarDialog(context: Context) : Dialog(context) {

    private val myAdapter = DialogAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_dialog)
        recyclerView.adapter = myAdapter
        setData()

    }

    private fun setData(){
        val list : MutableList<MyModel> = mutableListOf()
        for (i in 0..70){
            list.add(MyModel(i,false))
        }

        myAdapter.models = list
    }



}