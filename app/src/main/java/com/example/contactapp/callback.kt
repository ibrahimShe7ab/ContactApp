package com.example.contactapp

import com.example.contactapp.Model.contactData

interface callback {

    fun onItemClickListener(item:contactData,position:Int)
}