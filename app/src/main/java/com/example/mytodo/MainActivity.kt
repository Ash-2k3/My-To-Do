package com.example.mytodo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.atifsoftwares.animatoolib.Animatoo


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
            Animatoo.animateSlideRight(this)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.delete_button,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {

            R.id.btn_delete_item -> {
                Toast.makeText(this,"Delete Btn Triggered",Toast.LENGTH_SHORT).show()
                 todoAdapter.deleteDoneTask()
                return true
            }
            else -> super.onOptionsItemSelected(item)

        }

    }



}