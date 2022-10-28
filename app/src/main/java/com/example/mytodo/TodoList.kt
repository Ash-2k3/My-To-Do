package com.example.mytodo



object TodoList {
    var todoList = mutableListOf<Todo>()

    fun setData (task : String){
        todoList.add(Todo(task))
    }

    fun getEntireList(): MutableList<Todo> {
        return todoList
    }

}





