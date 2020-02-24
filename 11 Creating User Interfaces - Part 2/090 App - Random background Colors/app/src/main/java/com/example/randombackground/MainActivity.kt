package com.example.randombackground

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var colorArray = arrayOf(Color.GREEN, Color.RED, Color.BLUE, Color.GRAY, Color.CYAN, Color.YELLOW)

        button_tap.setOnClickListener {
            mainview.setBackgroundColor(colorArray[getRandom(colorArray.size)])
        }
    }

    fun getRandom(arraysize:Int) : Int
    {
        var random = Random()
        var randomNum = random.nextInt(arraysize)

        return randomNum
    }
}
