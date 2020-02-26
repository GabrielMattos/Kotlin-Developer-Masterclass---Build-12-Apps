package com.example.shownextactivity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var data = intent.extras

        if(data != null)
        {
            var name = data.get("name")
            var char = data.get("char")
            var int = data.get("int")

            Toast.makeText(this, name.toString() + " char: " + char + " Int: " + int, Toast.LENGTH_LONG).show()

            button_goBack_ID.setOnClickListener {
                val returnIntent = this.intent
                returnIntent.putExtra("return", "hello test from second activity")
                setResult(Activity.RESULT_OK, returnIntent)
                finish()
            }

        }
    }
}
