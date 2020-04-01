package com.example.mychatapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mychatapp.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_status.*

class StatusActivity : AppCompatActivity() {

    var mDatabase: DatabaseReference? = null
    var mCurrentUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)

        supportActionBar!!.title = "Status"

        if(intent.extras != null)
        {
            var oldStatus = intent.extras!!.get("status")
            editText_statusUpdate_ID.setText(oldStatus.toString())
        }

        if(intent.extras?.equals(null)!!)
        {
            editText_statusUpdate_ID.setText("Enter Your New Status")
        }

        button_statusUpdate_ID.setOnClickListener {

            mCurrentUser = FirebaseAuth.getInstance().currentUser
            var userId = mCurrentUser!!.uid
            mDatabase = FirebaseDatabase.getInstance().reference.child("Users").child(userId)
            var status = editText_statusUpdate_ID.text.toString().trim()
            mDatabase!!.child("status").setValue(status).addOnCompleteListener {
                task: Task<Void> ->
                if(task.isSuccessful)
                {
                    Toast.makeText(this, "Status Updated Successfully!", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, SettingsActivity::class.java))
                }
                else
                {
                    Toast.makeText(this, "Status NOT Updated!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
