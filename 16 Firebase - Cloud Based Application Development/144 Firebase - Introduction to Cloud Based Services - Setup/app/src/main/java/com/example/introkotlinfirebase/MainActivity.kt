package com.example.introkotlinfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firebaseDatabas = FirebaseDatabase.getInstance()
        var databaseRef = firebaseDatabas.reference

        databaseRef.setValue("Hello there!")
    }
}
