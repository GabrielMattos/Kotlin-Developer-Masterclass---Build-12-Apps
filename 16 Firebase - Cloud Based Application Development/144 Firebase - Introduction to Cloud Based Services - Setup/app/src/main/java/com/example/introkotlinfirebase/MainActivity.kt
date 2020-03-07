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
        var databaseRef = firebaseDatabas.getReference("messages")

        databaseRef.setValue("Hello there!")

        //Read from our DB
        databaseRef.addValueEventListener(object:ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

                Log.d("Error: ", error!!.toString())
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var value = dataSnapshot!!.value
                Log.d("VALUE: ", value.toString())
            }
        })
    }
}
