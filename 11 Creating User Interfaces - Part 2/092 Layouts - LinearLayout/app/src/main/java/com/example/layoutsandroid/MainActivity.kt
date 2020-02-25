package com.example.layoutsandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add(10, 20)
    }

    fun add(firstNum:Int, secondNum:Int)
    {
         println("Sum is: ${firstNum + secondNum}")
    }

    override fun onPause() {
        super.onPause()
    }
}
