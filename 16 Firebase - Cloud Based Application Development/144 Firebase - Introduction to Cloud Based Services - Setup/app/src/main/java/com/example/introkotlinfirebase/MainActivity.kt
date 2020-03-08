package com.example.introkotlinfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mAuth:FirebaseAuth? = null
    private var currentUser:FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firebaseDatabas = FirebaseDatabase.getInstance()
        var databaseRef = firebaseDatabas.getReference("messages").push()

        mAuth = FirebaseAuth.getInstance()

        //Create new User

        button_createAccount_ID.setOnClickListener {

            var email = editText_email_ID.text.toString().trim()
            var password = editText_password_ID.text.toString().trim()

            mAuth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                task: Task<AuthResult> ->
                if(task.isSuccessful)
                {
                    var user:FirebaseUser = mAuth!!.currentUser!!
                    Log.d("USER: ", user.email.toString())
                }
                
                else
                {
                    Log.d("error: ", task.exception.toString())
                }
            }
        }

        //Sign existing user in
        mAuth!!.signInWithEmailAndPassword("paulo@me.com", "password").addOnCompleteListener {
            task:Task<AuthResult> ->
            if(task.isSuccessful)
            {
                //Sign in was successful
                Toast.makeText(this, "Sign in was successful", Toast.LENGTH_LONG).show()
            }

            else
            {
                //Not sucessful
                Toast.makeText(this, "Sign in was UNsuccessful", Toast.LENGTH_LONG).show()
            }
        }

        /*var employee = Employee("James", "Android Developer", "123 Street", 25)


        //databaseRef.setValue(employee)

        //Read from our DB
        databaseRef.addValueEventListener(object:ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

                //Log.d("Error: ", error!!.toString())
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                //var value = dataSnapshot!!.value as HashMap<String, Any>
                //Log.d("VALUE: ", value.get("name").toString())
            }
        })*/
    }

    override fun onStart()
    {
        super.onStart()
        currentUser = mAuth!!.currentUser
        if(currentUser != null)
        {
            Toast.makeText(this, "User Is logged in", Toast.LENGTH_LONG).show()
        }

        else
        {
            Toast.makeText(this, "User Is logged out", Toast.LENGTH_LONG).show()
        }
        //call a function to update the userInterface with current user
    }

    data class Employee(var name:String, var position:String, var homeAdress:String, var age:Int)
    {

    }
}
