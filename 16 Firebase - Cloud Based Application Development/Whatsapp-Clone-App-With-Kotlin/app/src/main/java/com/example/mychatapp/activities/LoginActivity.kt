package com.example.mychatapp.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mychatapp.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    var mDatabase: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        button_login_ID.setOnClickListener {
            var email = editText_loginEmail_ID.text.toString().trim()
            var password = editText_loginPassword_ID.text.toString().trim()

            if (!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)) {
                loginUser(email, password)
            }
            else
            {
                Toast.makeText(this, "Sorry, login failed!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun  loginUser(email: String, password: String) {

        mAuth!!.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                    task: Task<AuthResult> ->
                if (task.isSuccessful) {
                    var username = email.split("@")[0] //paulo@gmail.com split--> [paulo],[gmail.com]
                    var dashboardIntent = Intent(this, DashboardActivity::class.java)
                    dashboardIntent.putExtra("name", username)
                    startActivity(dashboardIntent)
                    finish()
                }
                else
                {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                }
        }
    }

}
