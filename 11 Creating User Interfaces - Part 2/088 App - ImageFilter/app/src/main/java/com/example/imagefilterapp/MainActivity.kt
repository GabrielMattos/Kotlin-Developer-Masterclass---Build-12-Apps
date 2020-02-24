package com.example.imagefilterapp

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorsArray = arrayOf(Color.BLACK, Color.CYAN, Color.BLUE, Color.GREEN, Color.DKGRAY, Color.GRAY, Color.RED, Color.TRANSPARENT, Color.WHITE)

        var porterModes = arrayListOf(PorterDuff.Mode.OVERLAY, PorterDuff.Mode.DST_ATOP, PorterDuff.Mode.DARKEN)

        imageView_cat.setOnClickListener {
            imageView_cat.setColorFilter(colorsArray[getRandom(colorsArray.size)], porterModes[getRandom(porterModes.size)])
        }
    }

    fun getRandom(arraysize:Int) : Int
    {
        var random = Random()
        var randomNum = random.nextInt(arraysize)

        return randomNum
    }
}
