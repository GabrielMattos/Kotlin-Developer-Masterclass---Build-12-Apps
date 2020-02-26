package com.example.shownextactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE:Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_goSecond_ID.setOnClickListener {
            var myIntent = Intent(this, SecondActivity::class.java)
            myIntent.putExtra("name", "John")
            myIntent.putExtra("char", 'G')
            myIntent.putExtra("int", 25)

            startActivityForResult(myIntent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                var result = data!!.extras!!.get("return").toString()
                Toast.makeText(this, result, Toast.LENGTH_LONG).show()
            }
        }
    }
}
