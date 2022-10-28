package com.example.mytodo

import android.view.View

object TodoList {
    var todoList = mutableListOf<Todo>()

    fun setData (task : String){
        todoList.add(Todo(task))
    }

    fun getEntireList(): MutableList<Todo> {
        return todoList
    }

    fun deleteDoneTask(){
        todoList.removeAll {
            Todo -> Todo.isDone
        }
    }

}