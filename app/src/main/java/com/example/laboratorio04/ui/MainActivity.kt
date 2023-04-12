package com.example.laboratorio04.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.laboratorio04.R
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var actionSave : Button
    private lateinit var nameInput : TextInputEditText
    private lateinit var emailInput : TextInputEditText
    private lateinit var telInput : TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListener()
    }

    public fun bind () {
        actionSave = findViewById(R.id.action_save)
        nameInput = findViewById(R.id.name_input)
        emailInput = findViewById(R.id.email_input)
        telInput = findViewById(R.id.tel_input)
    }

    public fun addListener () {
        actionSave.setOnClickListener{_ ->
            val intent = Intent(this,  ShareActivity::class.java)
            intent.putExtra(SHARED_NAME, nameInput.text.toString())
            intent.putExtra(SHARED_EMAIL, emailInput.text.toString())
            intent.putExtra(SHARED_TEL, telInput.text.toString())
            startActivity(intent)
        }
    }
    companion object {
        const val SHARED_NAME = "name"
        const val SHARED_EMAIL = "email"
        const val SHARED_TEL = "tel"
    }
}