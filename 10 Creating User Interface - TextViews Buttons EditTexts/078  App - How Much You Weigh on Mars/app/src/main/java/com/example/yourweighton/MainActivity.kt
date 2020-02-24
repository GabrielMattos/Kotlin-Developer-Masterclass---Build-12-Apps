package com.example.yourweighton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val marsGravity:Float = 0.38f
    val venusGravity:Float = 0.91f
    val jupiterGravity:Float = 2.34f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weight = editText_enter_ID.text

        button_show_ID.setOnClickListener {
            var result = calculateWeight(weight.toString().toDouble())
            textView_result_ID.text = "You weight " + result.toString() + " on Mars"
        }

        checkBox_mars.setOnClickListener(this) //registering our clicklistener
        checkBox_jupiter.setOnClickListener(this)
        checkBox_venus.setOnClickListener(this)
    }

    private fun calculateWeight(userWeight:Double) : Double
    {
        return userWeight * marsGravity
    }

    override fun onClick(v: View?) {

        v as CheckBox
        var isChecked:Boolean = v.isChecked

        when(v.id)
        {
            R.id.checkBox_mars -> if(isChecked){Log.d("Setup Mars", "Mars")}
            R.id.checkBox_jupiter -> if(isChecked){Log.d("Setup Jupiter", "Jupiter")}
            R.id.checkBox_venus -> if(isChecked){Log.d("Setup Venus", "Venus")}
        }
    }
}
