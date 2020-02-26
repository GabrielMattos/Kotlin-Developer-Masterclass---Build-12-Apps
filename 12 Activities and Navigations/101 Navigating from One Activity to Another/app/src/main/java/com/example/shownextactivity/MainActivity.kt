package com.example.shownextactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_goSecond_ID.setOnClickListener {
            var myIntent = Intent(this, SecondActivity::class.java)
            myIntent.putExtra("name", "John")
            myIntent.putExtra("char", 'G')
            myIntent.putExtra("int", 25)

            startActivity(myIntent)
        }
    }
}
