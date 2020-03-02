 package com.example.recipefindermyapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recipefindermyapp.R
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_search_ID.setOnClickListener {
            startActivity(Intent(this, RecipeList::class.java))
        }
    }
}
