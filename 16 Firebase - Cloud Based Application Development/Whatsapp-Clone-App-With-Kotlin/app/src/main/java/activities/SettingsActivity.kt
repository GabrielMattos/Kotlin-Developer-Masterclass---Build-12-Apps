package activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mychatapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    var mDatabase:DatabaseReference? = null
    var mCurrentUser:FirebaseUser? = null
    var mStorageRef:StorageReference? = null
    var GALLERY_ID:Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        mCurrentUser = FirebaseAuth.getInstance().currentUser
        var userId = mCurrentUser!!.uid
        mDatabase = FirebaseDatabase.getInstance().reference.child("Users").child(userId)

        mDatabase!!.addValueEventListener(object:ValueEventListener{

            override fun onCancelled(databaseErrorSnapshot: DatabaseError) {

            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var displayName = dataSnapshot!!.child("display_name").value
                var image = dataSnapshot!!.child("image").value
                var userStatus = dataSnapshot!!.child("status").value
                var thumbnail = dataSnapshot!!.child("thumb_image").value

                textView_displayName_ID.text = displayName.toString()
                textView_status_ID.text = userStatus.toString()
            }
        })

        button_changeStatus_ID.setOnClickListener {
            var intent = Intent(this, StatusActivity::class.java)
            intent.putExtra("status", textView_status_ID.text.toString().trim())
            startActivity(intent)
        }

        button_changeImage_ID.setOnClickListener {
            var galleryIntent = Intent()
            galleryIntent.type = "image/*"
            galleryIntent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(galleryIntent, "SELECT_IMAGE"), GALLERY_ID)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
