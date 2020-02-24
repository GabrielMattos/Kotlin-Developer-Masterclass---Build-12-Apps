package com.example.checkboxwidge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCheckBoxClicked(view:View)
    {
        view as CheckBox // cast our view as a checkbox object or type or view
        var isChecked:Boolean = view.isChecked

        when(view.id)
        {
            R.id.checkBox_veg -> if(isChecked) {Log.d("Veggies", "IsChecked")} else {Log.d("Veggies", "IsNotChecked")}
            R.id.checkBox_meat -> if(isChecked) {Log.d("Meat", "IsChecked")} else {Log.d("Meat", "IsNotChecked")}
            R.id.checkBox_fruit -> if(isChecked) {Log.d("Fruit", "IsChecked")} else {Log.d("Fruit", "IsNotChecked")}
        }//Switch

        //Log.d("Checks", "Checkbox clicked")
    }
}
