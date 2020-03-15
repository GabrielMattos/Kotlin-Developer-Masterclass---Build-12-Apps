package com.example.mychatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.HashMap

class CreateAccountActivity : AppCompatActivity() {

    var mAuth:FirebaseAuth? = null
    var mDatabase:DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        mAuth = FirebaseAuth.getInstance()

        button_accountCreate_ID.setOnClickListener {
            var email:String = editText_emailDisplayName_ID.text.toString().trim()
            var password:String = editText_passwordDisplayName_ID.text.toString().trim()
            var displayName:String = editText_accountDisplayName_ID.text.toString().trim()

            if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password) || !TextUtils.isEmpty(displayName))
            {
                createAccount(email, password,displayName)
            } else
            {
                Toast.makeText(this, "Please enter fill out the fields", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun createAccount(email:String, password:String, displayName:String)
    {
        mAuth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            task: Task<AuthResult> ->
            if(task.isSuccessful)
            {
                var currentUser = mAuth!!.currentUser
                var user_ID = currentUser!!.uid
                mDatabase = FirebaseDatabase.getInstance().reference.child("Users").child(user_ID)


                var userObject = HashMap<String, String>()
                userObject.put("display_name", displayName)
                userObject.put("status", "Hello...")
                userObject.put("image", "default")
                userObject.put("thumb_image", "default")

                mDatabase!!.setValue(userObject).addOnCompleteListener {
                    task: Task<Void> ->
                    if(task.isSuccessful)
                    {
                        Toast.makeText(this, "User created! 302010", Toast.LENGTH_LONG).show()
                    }
                    else
                    {
                        Toast.makeText(this, "User NOT created! 102030", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
