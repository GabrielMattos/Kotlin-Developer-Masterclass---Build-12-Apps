package com.example.thesimplelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var namesArray:Array<String> = arrayOf("aa", "bb", "cc", "aa", "bb", "cc", "aa", "bb", "cc", "aa", "bb", "cc", "aa", "bb", "cc")
        var namesAdapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesArray)

        listview_ID.adapter = namesAdapter

        listview_ID.setOnItemClickListener { parent, view, position, id ->
            var itemName:String = listview_ID.getItemAtPosition(position).toString()
            Toast.makeText(this, "Name: $itemName", Toast.LENGTH_LONG).show()
        }
    }
}
