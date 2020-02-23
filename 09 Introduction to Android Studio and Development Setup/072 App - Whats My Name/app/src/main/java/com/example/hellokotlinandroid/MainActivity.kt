package com.example.hellokotlinandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var enterText = editText_entername_ID.text

        button_showNameID.setOnClickListener { textView_result_ID.text = enterText }

    }
}
