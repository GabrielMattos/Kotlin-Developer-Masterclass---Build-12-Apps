package activities

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mychatapp.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.squareup.picasso.Picasso
import com.theartofdev.edmodo.cropper.CropImage
import id.zelory.compressor.Compressor
import kotlinx.android.synthetic.main.activity_settings.*
import java.io.ByteArrayOutputStream
import java.io.File

class SettingsActivity : AppCompatActivity() {
    var mDatabase: DatabaseReference? = null
    var mCurrentUser: FirebaseUser? = null
    var mStorageRef: StorageReference? = null
    var GALLERY_ID: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        mCurrentUser = FirebaseAuth.getInstance().currentUser
        mStorageRef = FirebaseStorage.getInstance().reference

        var userId = mCurrentUser!!.uid

        mDatabase = FirebaseDatabase.getInstance().reference
            .child("Users")
            .child(userId)

        mDatabase!!.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(dataSnapshot: DataSnapshot)
            {
                var displayName = dataSnapshot!!.child("display_name").value
                var image = dataSnapshot!!.child("image").value.toString()
                var userStatus = dataSnapshot!!.child("status").value
                var thumbnail = dataSnapshot!!.child("thumb_image").value

                textView_displayName_ID.text = displayName.toString()
                textView_status_ID.text = userStatus.toString()

                if (!image!!.equals("default"))
                {
                    Picasso.get()
                        .load(image)
                        .placeholder(R.drawable.profile_img)
                        .into(circleImageView_settingsProfile_ID)
                }
            }

            override fun onCancelled(p0: DatabaseError)
            {

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        if (requestCode == GALLERY_ID && resultCode == Activity.RESULT_OK)
        {
            var image: Uri? = data!!.data

            CropImage.activity(image)
                .setAspectRatio(1, 1)
                .start(this)
        }

        if (requestCode === CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE)
        {
            val result = CropImage.getActivityResult(data)

            if (resultCode === Activity.RESULT_OK)
            {

                val resultUri = result.uri
                var userId:String = mCurrentUser!!.uid
                var thumbFile = File(resultUri.path)

                var thumbBitmap = Compressor(this)
                    .setMaxWidth(200)
                    .setMaxHeight(200)
                    .setQuality(65)
                    .compressToBitmap(thumbFile)

                //We upload images to firebase
                var byteArray = ByteArrayOutputStream()
                thumbBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArray)
                var thumbByteArray: ByteArray
                thumbByteArray = byteArray.toByteArray()

                var filePath = mStorageRef!!.child("chat_profile_images")
                    .child("$userId.jpg")

                //Create another directory for thumbimages ( smaller, compressed images)
                var thumbFilePath = mStorageRef!!.child("chat_profile_images")
                    .child("thumbs")
                    .child("$userId.jpg")


                filePath.putFile(resultUri)
                    .addOnCompleteListener { task: Task<UploadTask.TaskSnapshot> ->
                        if (task.isSuccessful)
                        {
                            //Let's get the pic url
                            val downloadUrl = task.result.toString()

                            //Upload Task
                            var uploadTask: UploadTask = thumbFilePath
                                .putBytes(thumbByteArray)

                            uploadTask.addOnCompleteListener { task: Task<UploadTask.TaskSnapshot> ->
                                val thumbUrl = task.result.toString()

                                if (task.isSuccessful)
                                {
                                    var updateObj = HashMap<String, Any>()
                                    updateObj.put("image", downloadUrl)
                                    updateObj.put("thumb_image", thumbUrl)

                                    //We save the profile image
                                    mDatabase!!.updateChildren(updateObj)
                                        .addOnCompleteListener { task: Task<Void> ->
                                            if (task.isSuccessful)
                                            {
                                                Toast.makeText(this, "Profile Image Saved!", Toast.LENGTH_LONG).show()
                                            }

                                            else
                                            {

                                            }
                                        }

                                }

                                else
                                {

                                }
                            }
                        }
                    }
            }

            else if (resultCode === CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE)
            {
                val error = result.error
                Log.d("Error", error.toString())
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}
