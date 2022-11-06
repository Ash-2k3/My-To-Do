package com.example.mytodo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.blogspot.atifsoftwares.animatoolib.Animatoo

class AddTodo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MyToDo)
        setContentView(R.layout.activity_add_todo)
        val etvTask : EditText = findViewById(R.id.etv_todo)
        val doneBtn : View = findViewById(R.id.fab_done)
        doneBtn.setOnClickListener{

            if(etvTask.text.isNotEmpty()){
                TodoList.setData(etvTask.text.toString())
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                Animatoo.animateSwipeRight(this)
                finish()
            }
            else{
                Toast.makeText(this,"Enter Valid Text",Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Animatoo.animateSlideRight(this)
    }
}