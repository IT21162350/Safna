package com.example.safna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

private lateinit var editBtn: Button;


class employer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employer)

        editBtn = findViewById(R.id.btnEdit);
        editBtn.setOnClickListener(){
            val profile = Intent(this, profile::class.java)
            startActivity(profile)
        }



    }
}