package com.example.introkotlinfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firebaseDatabas = FirebaseDatabase.getInstance()
        var databaseRef = firebaseDatabas.getReference("messages").push()

        var employee = Employee("James", "Android Developer", "123 Street", 25)

        databaseRef.setValue(employee)

        //Read from our DB
        databaseRef.addValueEventListener(object:ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

                Log.d("Error: ", error!!.toString())
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var value = dataSnapshot!!.value as HashMap<String, Any>
                Log.d("VALUE: ", value.get("name").toString())
            }
        })
    }

    data class Employee(var name:String, var position:String, var homeAdress:String, var age:Int)
    {

    }
}
