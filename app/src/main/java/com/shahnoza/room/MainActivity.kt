package com.shahnoza.room

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shahnoza.room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var myAppDatabase: MyAppDatabase
    lateinit var list: ArrayList<MyUser>
    lateinit var binding: ActivityMainBinding
    var maxId:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list=ArrayList()
        myAppDatabase=MyAppDatabase.getInstance(this)
        if (myAppDatabase.myDao().getAllUsers().isNotEmpty()){
            maxId=myAppDatabase.myDao().getAllUsers().size+1
        }else{
            maxId=1
        }

        binding.btnSave.setOnClickListener {
            var name=binding.edtName.text.toString().trim()
            var surname=binding.edtSurname.text.toString().trim()

            myAppDatabase.myDao().addUser(MyUser(maxId,name,surname))
            Toast.makeText(this, "Saqlandi!", Toast.LENGTH_SHORT).show()
            maxId++
            binding.edtName.text.clear()
            binding.edtSurname.text.clear()
        }

        binding.btnGetData.setOnClickListener {
            binding.myTextView.text = myAppDatabase.myDao().getAllUsers().get(1).toString()
        }

    }
}