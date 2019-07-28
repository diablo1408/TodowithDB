package com.example.todowithdb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_todo.view.*





class TaskAdapter(var Tasks:ArrayList<TasksTable.Task>): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
//    private var Tasks: ArrayList<TasksTable.Task>? = null
//    var context: Context? = null
    var onClickListener: DetailsAdapterListener? = null

//    constructor(tasks: ArrayList<TasksTable.Task>?=null) : super() {
//        this.Tasks = tasks
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val li = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = li.inflate(R.layout.layout_todo, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount() = Tasks.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

         var taskDB = getItem(position)
        holder.bind(taskDB)
        holder.itemView.ivDelete.setOnClickListener {
            onClickListener?.deleteonclick(it, position,taskDB)

        }
        holder.itemView.cBox.setOnCheckedChangeListener { buttonView, isChecked ->


            onClickListener?.checkonclick(isChecked,taskDB)
        }


//

    }


    fun updateTasks(newTasks: ArrayList<TasksTable.Task>) {
        Tasks.clear()
        Tasks.addAll(newTasks)
        notifyDataSetChanged()

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//          val thistask=getItem(adapterPosition)

//        constructor(itemView: View) : super(itemView) {
//            super.itemView
//
//
//
//
//        }
        fun bind(taskDB: TasksTable.Task) {
            itemView.todoTv.text = taskDB.task
            if (taskDB.done) {

                itemView.todoTv.setBackgroundColor(Color.GRAY)


            }
          else{
                itemView.todoTv.setBackgroundColor(Color.WHITE)
            }

        }

    }


    fun getItem(position: Int): TasksTable.Task = Tasks[position]



}


