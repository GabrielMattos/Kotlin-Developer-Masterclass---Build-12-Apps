package com.example.simplelistviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var namesAdapter:ArrayAdapter<String>
        var namesArray:Array<String> = arrayOf("aa", "bb", "cc", "aa", "bb", "cc", "aa", "bb", "cc", "aa", "bb", "cc", "aa", "bb", "cc", "aa", "bb", "cc", "aa", "bb", "cc")

        namesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesArray)
        myListview_ID.adapter = namesAdapter
    }
}
