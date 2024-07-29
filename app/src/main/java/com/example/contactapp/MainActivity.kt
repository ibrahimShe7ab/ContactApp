 package com.example.contactapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.Adapter.contactAdapter
import com.example.contactapp.Model.contactData
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var adapter: contactAdapter
    var data = mutableListOf<contactData>()
    lateinit var recyclerView: RecyclerView
    lateinit var name: TextInputEditText
    lateinit var phone: TextInputEditText
    lateinit var description: TextInputEditText
    lateinit var save: MaterialButton
    lateinit var nameTextInputLayout: TextInputLayout
    lateinit var phoneTextInputLayout: TextInputLayout
    lateinit var descriptionTextInputLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initItems()

        adapter = contactAdapter(data)
        navInit()
        recyclerView.adapter = adapter

        buttonSaveClicked()
    }

    private fun navInit() {
        adapter.onItemClickListener = object : callback {
            override fun onItemClickListener(item: contactData, position: Int) {
                val intent = Intent(this@MainActivity, DetialsActivity::class.java)
                intent.putExtra(consts.NAME, item.name)
                intent.putExtra(consts.PHONE, item.phone)
                intent.putExtra(consts.DESCRIPTION, item.description)
                startActivity(intent)
            }
        }
    }

    private fun initItems() {
        recyclerView = findViewById(R.id.contact_recyclerView)
        name = findViewById(R.id.name_TextInputEditText)
        phone = findViewById(R.id.phone_TextInputEditText)
        description = findViewById(R.id.description_TextInputEditText)
        save = findViewById(R.id.sav_btn)
        nameTextInputLayout = findViewById(R.id.name_TextInputLayout)
        phoneTextInputLayout = findViewById(R.id.phone_TextInputLayout)
        descriptionTextInputLayout = findViewById(R.id.description_TextInputLayout)
    }

    private fun buttonSaveClicked() {
        save.setOnClickListener {
            val NAME = name.text?.trim().toString()
            val PHONE = phone.text?.trim().toString()
            val DESCRIPTION = description.text?.trim().toString()

            var isValid = true

            if (NAME.length < 3) {

                nameTextInputLayout.error = "Name must be at least 3 characters long"
                nameTextInputLayout.setErrorIconDrawable(R.drawable.ic_error)
                isValid = false
            } else {
                nameTextInputLayout.error = null
            }

            if (PHONE.length < 11) {
                phoneTextInputLayout.error = "Phone number must be at least 11 digits"
                phoneTextInputLayout.setErrorIconDrawable(R.drawable.ic_error)
                isValid = false
            } else {
                phoneTextInputLayout.error = null
            }

            if (isValid) {
                data.add(contactData(NAME, PHONE, R.drawable.contact_avater, DESCRIPTION))
                adapter.notifyItemInserted(data.size - 1)


            }
        }
    }
}
