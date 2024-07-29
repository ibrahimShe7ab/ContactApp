package com.example.contactapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetialsActivity : AppCompatActivity() {

    lateinit var nameTV:TextView
    lateinit var phoneTv:TextView
    lateinit var descriptionTV:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detials)
      nameTV=findViewById(R.id.nameView)
        phoneTv=findViewById(R.id.phoneView)
        descriptionTV=findViewById(R.id.descriptionView)
//        val intent=Intent()
//        val nameContent= intent.getStringExtra(consts.NAME)
//        nameTV.text=nameContent
//        val phoneContent= intent.getStringExtra(consts.PHOEN)
//        phoneTv.text=phoneContent
//
//        val descriptionContent= intent.getStringExtra(consts.DESCRIPTION)
//        descriptionTV.text=descriptionContent











        val intent = intent

        // Retrieve data from the Intent
        val nameContent = intent.getStringExtra(consts.NAME)
        val phoneContent = intent.getStringExtra(consts.PHONE)
        val descriptionContent = intent.getStringExtra(consts.DESCRIPTION)

        // Set the text views with the data
        nameTV.text = nameContent
        phoneTv.text = phoneContent
        descriptionTV.text = descriptionContent







    }
}