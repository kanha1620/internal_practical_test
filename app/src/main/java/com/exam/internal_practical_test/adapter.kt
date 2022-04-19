package com.exam.internal_practical_test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cardview.view.*


class adapter(val context:Context,var arr:ArrayList<fruit>)
    :RecyclerView.Adapter<adapter.PersonViewHolder>()

{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        var inflater=LayoutInflater.from(parent.context)
        var view= inflater.inflate(R.layout.cardview,parent,false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(arr[position])
    }

    override fun getItemCount(): Int {
        return  arr.size
    }

    class PersonViewHolder(var view:View):RecyclerView.ViewHolder(view)
    {
        fun bind(p:fruit)
        {
            view.name.setText(p.Fr_des)
            view.price.setText(p.Fr_price.toString())
            view.desc.setText(p.Fr_name)

        }
    }
}