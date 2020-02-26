package com.example.animalbios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cheetah = imageView_cheetah_ID
        var lion = imageView_lion_ID

        //register our views to receive onClickListener events
        cheetah.setOnClickListener(this)
        lion.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id)
        {
            imageView_cheetah_ID.id -> {
                Toast.makeText(this, "Cheetah", Toast.LENGTH_LONG).show()
            }
            imageView_lion_ID.id -> {
                Toast.makeText(this, "Lion", Toast.LENGTH_LONG).show()
            }
        }
    }
}
