package com.example.roomdatabase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.data.room.UserEntity

class UserAdapter(private val list: List<UserEntity>):
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: UserEntity = list[position]
        holder.bind(model)

    }


    override fun getItemCount(): Int = list.size


    class ViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.user_layout, parent, false)) {

        private var username: TextView? = null
        private var contact: TextView? = null
        private var other: TextView? = null

        init {
            username = itemView.findViewById(R.id.user_name)
            contact = itemView.findViewById(R.id.user_contact)
            other = itemView.findViewById(R.id.other)
        }

        fun bind(userEntity: UserEntity) {
            username!!.text = userEntity.name
            contact!!.text = userEntity.contact
            other!!.text = userEntity.other
        }
    }
}