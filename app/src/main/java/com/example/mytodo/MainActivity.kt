package com.example.mytodo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: MyTodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myRv = findViewById<RecyclerView>(R.id.rv_list_todo)
        val addBtn = findViewById<View>(R.id.fab_add)

        todoAdapter = MyTodoAdapter(TodoList.getEntireList())
        myRv.adapter = todoAdapter
        myRv.layoutManager = LinearLayoutManager(this)

        addBtn.setOnClickListener{
            val intent = Intent(this,AddTodo::class.java)
            startActivity(intent)
            finish()
        }
    }
}