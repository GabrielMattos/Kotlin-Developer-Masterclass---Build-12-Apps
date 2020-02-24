package com.example.yourweighton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val marsGravity:Float = 0.38f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weight = editText_enter_ID.text

        button_show_ID.setOnClickListener {
            var result = calculateWeight(weight.toString().toDouble())
            textView_result_ID.text = "You weight " + result.toString() + " on Mars"
        }
    }

    fun calculateWeight(userWeight:Double) : Double
    {
        return userWeight * marsGravity
    }
}
