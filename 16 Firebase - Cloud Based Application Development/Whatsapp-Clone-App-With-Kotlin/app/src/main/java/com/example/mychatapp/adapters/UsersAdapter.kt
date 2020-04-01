package com.example.mychatapp.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mychatapp.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import de.hdodenhof.circleimageview.CircleImageView
import com.example.mychatapp.models.Users

class UsersAdapter(databaseQuery:DatabaseReference, var context:Context) : FirebaseRecyclerAdapter<Users, UsersAdapter.ViewHolder>(
    Users::class.java,
    R.layout.users_row,
    UsersAdapter.ViewHolder::class.java,
    databaseQuery
)
{
    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
    {
        var userNameTxt:String? = null
        var userStatusTxt:String? = null
        var userProfilePicLink:String? = null

        fun bindView(user: Users, context:Context)
        {
            var userName = itemView.findViewById<TextView>(R.id.userName)
            var userStatus = itemView.findViewById<TextView>(R.id.userStatus)
            var userProfilPic = itemView.findViewById<CircleImageView>(R.id.usersProfile)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.ViewHolder
    {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(viewHolder: UsersAdapter.ViewHolder, position: Int, model: Users)
    {
        TODO("Not yet implemented")
    }
}