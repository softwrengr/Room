package com.example.roomdatabase.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class UserEntity(
val name:String?,

val contact:String?,

@ColumnInfo(name = "other",defaultValue = "")
val other:String?
){
    @PrimaryKey(autoGenerate = true)
    var id : Int?=null
}