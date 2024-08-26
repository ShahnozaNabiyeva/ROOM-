package com.shahnoza.room.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.shahnoza.room.MyUser

@Dao
interface MyDao {

    @Transaction
    @Query("select * from MyUser")  // databasedan ma'lumotlarni olish
    fun getAllUsers():List<MyUser>

    @Insert
    fun addUser(myUser: MyUser)  // databasega ma'lumot qo'shish


    @Delete(entity = MyUser::class) // databasedan ma'lumot o'chirish
    fun deleteUser(myUser: MyUser)


    @Update(entity = MyUser::class) // databasedagi ma'lumotni o'gartirish
    fun editUser(myUser: MyUser)

}