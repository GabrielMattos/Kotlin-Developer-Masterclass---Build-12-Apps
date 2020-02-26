package com.example.recycleviewapp.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewapp.R
import com.example.recycleviewapp.model.Person

class PersonListAdapter(private val list:ArrayList<Person>, private val context:Context) : RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //create our view from our xml file
        val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)
        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.bindItem(list[position])
    }

    inner class ViewHolder(itemView:View, context:Context) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(person:Person)
        {
            var name:TextView = itemView.findViewById(R.id.name) as TextView
            var age:TextView = itemView.findViewById(R.id.age) as TextView

            name.text = person.name
            age.text = person.age.toString()

            itemView.setOnClickListener {
                //context.startActivity(this, SecondActivity::java.class)
                Toast.makeText(context, name.text, Toast.LENGTH_LONG).show()
            }
        }
    }

}