package com.example.recipefindermyapp.data

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipefindermyapp.R
import com.example.recipefindermyapp.model.Recipe
import com.squareup.picasso.Picasso
import com.squareup.picasso.PicassoProvider

class RecipeListAdapter(private val list:ArrayList<Recipe>, val context:Context): RecyclerView.Adapter<RecipeListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecipeListAdapter.ViewHolder
    {
        val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: RecipeListAdapter.ViewHolder, position: Int)
    {
        if(holder != null)
        {
            holder.bindView(list[position])
        }
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        var title = itemView.findViewById<TextView>(R.id.textView_recipeTitle_ID)
        var thumbnail = itemView.findViewById<ImageView>(R.id.imageView_thumbnail_ID)
        var ingredients = itemView.findViewById<TextView>(R.id.textView_recipeIngredients_ID)
        var linkButton = itemView.findViewById<Button>(R.id.button_linkButton_ID)

        fun bindView(recipe:Recipe)
        {
            title.text = recipe.title
            ingredients.text = recipe.ingredients
            linkButton.setOnClickListener {  }

            if(!TextUtils.isEmpty(recipe.thumbnail))
            {
                //No vídeo diz Picasso.with(context)
                Picasso.get().load(recipe.thumbnail).placeholder(R.drawable.ic_launcher_foreground).error(R.drawable.ic_launcher_foreground).into(thumbnail)
            }

            else
            {
                //No vídeo diz Picasso.with(context)
                Picasso.get().load(recipe.thumbnail).placeholder(R.drawable.ic_launcher_foreground).into(thumbnail)
            }
        }
    }
}