package com.example.recipefindermyapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.recipefindermyapp.R
import com.example.recipefindermyapp.model.Recipe
import org.json.JSONException
import org.json.JSONObject

class RecipeList : AppCompatActivity() {

    var volleyRequest:RequestQueue? = null
    var recipeList:ArrayList<Recipe>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        var urlString = "http://www.recipepuppy.com/api/?i=onions,garlic&q=omelet&p=3"

        recipeList = ArrayList<Recipe>()

        volleyRequest = Volley.newRequestQueue(this)

        getRecipe(urlString)
    }

    fun getRecipe(url:String)
    {
        var recipeRequest = JsonObjectRequest(Request.Method.GET, url, Response.Listener {
            response: JSONObject ->
            try {
                val resultArray = response.getJSONArray("results")
                for (i in 0..resultArray.length() - 1)
                {
                    var recipeObj = resultArray.getJSONObject(i)


                    var title = recipeObj.getString("title")
                    var link = recipeObj.getString("href")
                    var thumbnail = recipeObj.getString("thumbnail")
                    var ingredients = recipeObj.getString("ingredients")

                    Log.d("Result====>>", title)

                    var recipe = Recipe()
                    recipe.title = title
                    recipe.link = link
                    recipe.thumbnail = thumbnail
                    recipe.ingredients = ingredients

                    recipeList!!.add(recipe)
                }
            } catch (e:JSONException) {
                e.printStackTrace()
            }
        },
            Response.ErrorListener {
                error:VolleyError? ->
                try {
                    Log.d("Error:", error.toString())
                } catch (e:JSONException) {
                    e.printStackTrace()
                }
            })

        volleyRequest!!.add(recipeRequest)
    }
}
