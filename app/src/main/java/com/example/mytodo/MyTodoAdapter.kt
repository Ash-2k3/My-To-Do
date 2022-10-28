package com.example.mytodo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyTodoAdapter(
    private val todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
       val currTodo = todos[position]
        holder.itemView.apply {
            findViewById<TextView>(R.id.tv_todo).text = currTodo.todo
            findViewById<CheckBox>(R.id.cb_check).isChecked = currTodo.isDone
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}

class TodoViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview)