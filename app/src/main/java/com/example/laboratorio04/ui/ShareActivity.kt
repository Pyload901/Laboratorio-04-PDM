package com.example.laboratorio04.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.laboratorio04.R

class ShareActivity : AppCompatActivity() {
    private lateinit var nameDisplay : TextView
    private lateinit var emailDisplay : TextView
    private lateinit var telDisplay : TextView
    private lateinit var actionShare : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        bind()
        setDisplay()
        addListener()
    }

    public fun bind () {
        nameDisplay = findViewById(R.id.name_display)
        emailDisplay = findViewById(R.id.email_display)
        telDisplay = findViewById(R.id.tel_display)
        actionShare = findViewById(R.id.action_share)
    }

    public fun setDisplay() {
        nameDisplay.text = "Nombre: " + intent.getStringExtra(MainActivity.SHARED_NAME).toString()
        emailDisplay.text = "Email: " + intent.getStringExtra(MainActivity.SHARED_EMAIL).toString()
        telDisplay.text =  "Teléfono: " + intent.getStringExtra(MainActivity.SHARED_TEL).toString()
    }

    public fun addListener() {
        actionShare.setOnClickListener {
            val intent= Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"INFORMACION")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"COMPARTIR A:"))
        }
    }
}