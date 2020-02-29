package com.example.volleyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    var volleyRequest:RequestQueue? = null
    val stringLink = "https://www.google.com.br" + "/?gws_rd=ssl"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        volleyRequest = Volley.newRequestQueue(this)
        getString(stringLink)
    }

    fun getString(Url:String)
    {
        val stringReg = StringRequest(Request.Method.GET, Url,
            Response.Listener {
                response:String? ->
                try {
                    Log.d("Response: ", response)
                } catch (e:JSONException) {
                    e.printStackTrace()
                }
            }, Response.ErrorListener {
                error: VolleyError? ->
                try {
                    Log.d("Error: ", error.toString())
                } catch (e:JSONException) {
                    e.printStackTrace()
                }
            })

        volleyRequest!!.add(stringReg)
    }
}
