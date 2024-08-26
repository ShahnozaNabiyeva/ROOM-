package com.shahnoza.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shahnoza.room.models.MyDao


@Database(entities = [MyUser::class], version = 1) // MyUser nomli database yaratib beradi

abstract class MyAppDatabase:RoomDatabase() {

    abstract fun myDao():MyDao // qo`shimcha funksiyalarimizdan foydalanish qoshish ochirish

    companion object{
        private var instance:MyAppDatabase?=null

        @Synchronized
        fun getInstance(context: Context):MyAppDatabase{ // funksiya ishlaganida databaseni aratib beradi
            if (instance==null){ // baz qurilmagan taqdirda ham bazani qurib beradi
                instance=Room.databaseBuilder(context,MyAppDatabase::class.java,"myusers.db")
                    .fallbackToDestructiveMigration() // eaki databaseni o'chirib yuborish
                    .allowMainThreadQueries() // asosiy oqimda ishlashga rozilik
                    .build()

            }
    return instance!!

        }

    }
}