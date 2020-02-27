package com.example.sharedprefsapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val PREFS_NAME = "myprefs"
    var mypref:SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_ID.setOnClickListener {

            mypref = getSharedPreferences(PREFS_NAME, 0)
            var editor:SharedPreferences.Editor = (mypref as SharedPreferences)!!.edit()

            if(!TextUtils.isEmpty(editText_ID.text.toString()))
            {
                var message:String = editText_ID.text.toString()
                editor.putString("message", message)
                editor.commit() //IMPORTANT!
            }

            else
            {
                Toast.makeText(this, "Please enter something", Toast.LENGTH_LONG).show()
            }
        }

        //Get data back
        var dataBack:SharedPreferences = getSharedPreferences(PREFS_NAME, 0)

        if(dataBack.contains("message"))
        {
            var myMessage = dataBack.getString("message", "not found!")
            textView_ID.text = myMessage
        }
    }
}
