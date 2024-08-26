package com.shahnoza.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyUser(
    @PrimaryKey(autoGenerate = false) val uid:Int,
    @ColumnInfo(name = "name") val userName:String?,
    @ColumnInfo(name="surname") val surName:String?
)
