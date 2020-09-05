package com.example.roomdatabase.views

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.adapter.UserAdapter
import com.example.roomdatabase.data.room.UserEntity
import com.example.roomdatabase.viewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel
    private var adapter: UserAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setRecyclerView()

        button_add_user.setOnClickListener {
            startActivityForResult(Intent(this,AddUserActivity::class.java),1)
        }

        button_clear.setOnClickListener {
            viewModel.deleteUser()
        }


    }

    private fun setRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter

        viewModel.getAllUser().observe(this, Observer { it

                recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = UserAdapter(it)
                }
            })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            val name = data!!.getStringExtra("name")
            val contact = data.getStringExtra("contact")
            val other = data.getStringExtra("other")
            viewModel.addUser(UserEntity(name,contact,other))

        }
    }
}