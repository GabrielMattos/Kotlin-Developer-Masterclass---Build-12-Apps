package com.example.imageviewapp

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var catImg = imageView_cat
        var dogImg = imageView_dog

        catImg.setColorFilter(Color.BLUE)
        dogImg.setColorFilter(Color.CYAN)

        catImg.setOnClickListener {
            catImg.clearColorFilter()
            //catImg.setColorFilter(Color.GREEN, PorterDuff.Mode.DARKEN)
            catImg.setBackgroundColor(Color.MAGENTA)
        }
    }
}
