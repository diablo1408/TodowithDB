//package com.example.todo2
//
//
//import android.content.ContentValues
//import android.database.sqlite.SQLiteDatabase
//import android.text.Editable
//import android.util.Log
//import android.widget.Toast
//
//class TasksTable {
//
//    data class Task (
//        val id: Int?,
//        val task: String,
//        var done: Boolean
//    )
//
//    companion object {
//        val TABLE_NAME = "tasks"
//
//        val CMD_CREATE_TABLE = """
//           CREATE TABLE $TABLE_NAME (
//           id INTEGER PRIMARY KEY AUTOINCREMENT,
//           task TEXT,
//           done BOOLEAN
//           );
//        """.trimIndent()
//
//        fun insertTask(db: SQLiteDatabase, task: Task) {
//
//            val taskRow = ContentValues()
//            taskRow.put("task", task.task)
//            taskRow.put("done", task.done)
//
//            db.insert(TABLE_NAME, null, taskRow)
//
//        }
//
//        fun updateTask(db: SQLiteDatabase, task: Task) {
//
//            val taskRow = ContentValues()
//            taskRow.put("task", task.task)
//            taskRow.put("done", task.done)
//
//            db.update(TABLE_NAME, taskRow, "id = ?", arrayOf(task.id.toString()))
//        }
//
//        fun removeTask(db: SQLiteDatabase){
//            db.delete(TABLE_NAME,"done = 1",null)
//
//        }
//        fun sortTask(db: SQLiteDatabase): ArrayList<Task>{
//            val tasks = ArrayList<Task>()
//            val cursor= db.query(TABLE_NAME,arrayOf("id", "task", "done"),null,null,null,null,"done"+" ASC")
//            cursor.moveToFirst()
//
//            val idCol = cursor.getColumnIndex("id")
//            val taskCol = cursor.getColumnIndex("task")
//            val doneCol = cursor.getColumnIndex("done")
//
//            while (cursor.moveToNext()) {
//                val task = Task(
//                    cursor.getInt(idCol),
//                    cursor.getString(taskCol),
//                    cursor.getInt(doneCol) == 1
//                )
//
//                tasks.add(task)
//            }
//            cursor.close()
//            return tasks
//        }
//        fun searchTask(db: SQLiteDatabase, ser: String): ArrayList<Task>{
//            val tasks = ArrayList<Task>()
//            var search ="%"+ser+"%"
//            Log.d("TAG","$search")
//
////            String[] args = {"$ser"}
////            var selectionArgs = arrayOf(" ")
////            var args= arrayOf("%"+"$ser"+"%")
//           Log.d("AG","$ser")
////           val cursor=  db.rawQuery("SELECT first_name, last_name " +
////                    "FROM people " +
////                    "WHERE id = %?%", args)
////            val cursor= db.query(TABLE_NAME,arrayOf("id", "task", "done"),"task LIKE ",null,null,null,null)
//            val table_column = "task"
//            var sql = "SELECT * FROM "+ TABLE_NAME +" WHERE " + table_column + " LIKE '" + ser + "'"
//            val cursor = db.rawQuery(sql,null)
//            Log.d("sql","$sql")
//
//            cursor.moveToFirst()
//            val idCol = cursor.getColumnIndex("id")
//            val taskCol = cursor.getColumnIndex("task")
//            val doneCol = cursor.getColumnIndex("done")
//
//            while (cursor.moveToNext()) {
//                val task = Task(
//                    cursor.getInt(idCol),
//                    cursor.getString(taskCol),
//                    cursor.getInt(doneCol) == 1
//                )
//
//                tasks.add(task)
//            }
//            cursor.close()
//            return tasks
//        }
//
//        fun getAllTasks(db: SQLiteDatabase): ArrayList<Task> {
//
//            val tasks = ArrayList<Task>()
//
//            val cursor = db.query(
//                TABLE_NAME,
//                arrayOf("id", "task", "done"),
//                null, null, //where
//                null, // group by
//                null, //having
//                null //order
//            )
//
//            cursor.moveToFirst()
//
//            val idCol = cursor.getColumnIndex("id")
//            val taskCol = cursor.getColumnIndex("task")
//            val doneCol = cursor.getColumnIndex("done")
//
//            while (cursor.moveToNext()) {
//                val task = Task(
//                    cursor.getInt(idCol),
//                    cursor.getString(taskCol),
//                    cursor.getInt(doneCol) == 1
//                )
//
//                tasks.add(task)
//            }
//            cursor.close()
//            return tasks
//        }
//
//    }
//}
//
//
//
