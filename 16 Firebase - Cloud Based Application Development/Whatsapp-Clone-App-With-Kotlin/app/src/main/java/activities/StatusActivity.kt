package activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mychatapp.R
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
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

        editText_statusUpdate_ID.setOnClickListener {

        }
    }
}
