package com.example.animalbios

import android.content.Intent
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
                var cheetahIntent = Intent(this, DetailsActivity::class.java)
                cheetahIntent.putExtra("animal", "cheetah")
                startActivity(cheetahIntent)
                //Toast.makeText(this, "Cheetah", Toast.LENGTH_LONG).show()
            }
            imageView_lion_ID.id -> {
                var lionIntent = Intent(this, DetailsActivity::class.java)
                lionIntent.putExtra("animal", "lion")
                startActivity(lionIntent)
                //Toast.makeText(this, "Lion", Toast.LENGTH_LONG).show()
            }
        }
    }
}
