package com.example.roomdatabase.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdatabase.R
import kotlinx.android.synthetic.main.activity_add_user.*

class AddUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)


        floating_action_button_save.setOnClickListener {
            saveUser()
        }

    }

    fun saveUser(){
        val name = user_name.text.toString()
        val contact = user_number.text.toString()
        val other = others.text.toString()

        val data = Intent()
        data.putExtra("name",name)
        data.putExtra("contact",contact)
        data.putExtra("other",other)
        setResult(Activity.RESULT_OK,data)
        finish()
    }
}