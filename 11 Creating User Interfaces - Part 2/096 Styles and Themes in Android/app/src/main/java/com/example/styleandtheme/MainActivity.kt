package com.example.styleandtheme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toast.makeText(getApplication(), "Hello", Toast.LENGTH_LONG).show()
        Log.v(TAG, getApplicationContext().getString(R.string.app_name))
        //Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show() //this == class == MainActivity == MainActivity.this
    }
}
