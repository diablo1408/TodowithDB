package com.example.todowithdb


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_todo.*
import java.text.ParsePosition


class MainActivity : AppCompatActivity() {



    var tasks = arrayListOf<TasksTable.Task>()

//
//fun getItem(position: Int): TasksTable.Task = tasks[position]


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = MyDbHelper(this)
        val tasksDb = dbHelper.writableDatabase
        tasks= TasksTable.getAllTasks(tasksDb)
        val taskAdapter=TaskAdapter(tasks)













        lvTodolist.layoutManager=LinearLayoutManager(this)
        taskAdapter.onClickListener=object:DetailsAdapterListener{
            override fun checkonclick(check: Boolean, thistask: TasksTable.Task) {
                if(check) {
                    thistask.done = check
                }
                else {
                    thistask.done = check
                }
                 TasksTable.updateTask(tasksDb,thistask)
                tasks = TasksTable.getAllTasks(tasksDb)
                taskAdapter.updateTasks(tasks)


            }

            override fun deleteonclick(v: View, position: Int, thistask: TasksTable.Task) {
                TasksTable.DeleteTask(tasksDb,thistask)
                tasks = TasksTable.getAllTasks(tasksDb)
                taskAdapter.updateTasks(tasks)


            }

        }
        lvTodolist.adapter = taskAdapter


//
           Refresh.setOnClickListener {
               tasks = TasksTable.getAllTasks(tasksDb)
               taskAdapter.updateTasks(tasks)
           }

//


        btnAdd.setOnClickListener {

            TasksTable.insertTask(
                tasksDb,
                TasksTable.Task(
                    null,
                    etNewItem.text.toString(),
                    false
                )
            )
            tasks = TasksTable.getAllTasks(tasksDb)
            taskAdapter.updateTasks(tasks)
            etNewItem.text.clear()


        }
        btnSort.setOnClickListener {
           tasks= TasksTable.sortTask(tasksDb)
            taskAdapter.updateTasks(tasks)
        }
        btnDeleteALL.setOnClickListener {
            TasksTable.deleteDoneTask(tasksDb)
            tasks = TasksTable.getAllTasks(tasksDb)
            taskAdapter.updateTasks(tasks)
        }







   }







}
