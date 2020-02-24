package com.example.buttonstextviewedittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var text = editText_enterName.text
        button_showName.setOnClickListener {
            if(text.isEmpty()) textView_result.text = "Enter name" else textView_result.text = "Welcome " + text
        }

    }
}
