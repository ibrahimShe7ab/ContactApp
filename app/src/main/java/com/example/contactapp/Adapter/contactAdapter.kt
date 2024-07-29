package com.example.contactapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.contactapp.Model.contactData
import com.example.contactapp.R
import com.example.contactapp.callback

class contactAdapter(val contacts:List<contactData>): Adapter<contactAdapter.contactViewHolder>() {
    var onItemClickListener: callback?=null

    class contactViewHolder(contactView: View):ViewHolder(contactView){
        val Name: TextView =contactView.findViewById<TextView>(R.id.profile_name)
        val Phone=contactView.findViewById<TextView>(R.id.profile_phone)
        val Img=contactView.findViewById<ImageView>(R.id.profile_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false)
    return contactViewHolder(view)

    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: contactViewHolder, position: Int) {
        val item=contacts[position]
        holder.Name.text=item.name
        holder.Phone.text=item.phone
        item.img?.let { holder.Img.setImageResource(it) }
        holder.itemView.setOnClickListener{

            onItemClickListener?.onItemClickListener(item,position)

        }
    }

}