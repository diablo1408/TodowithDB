package com.example.todowithdb

import android.view.View

interface DetailsAdapterListener {

    fun checkonclick(check:Boolean,thistask:TasksTable.Task)

    fun deleteonclick(v: View, position: Int, thistask:TasksTable.Task)
}