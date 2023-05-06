package com.example.safna.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.safna.R

private lateinit var editBtn: Button;


class employer : AppCompatActivity() {

    private lateinit var tvEmpId: TextView
    private lateinit var tvEmpName: TextView
    private lateinit var tvJob: TextView
    private lateinit var tvEmpLikedin: TextView
    private lateinit var tvEmpContact: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employer)
        init()

        var btnUpdate: Button;
        btnUpdate = findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(){
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }

    }
    private fun init(){
        tvEmpId = findViewById(R.id.tvEmpId)
        tvEmpName = findViewById(R.id.tvEmpName)
        tvJob = findViewById(R.id.tvEmail)
        tvEmpLikedin = findViewById(R.id.tvLikedIn)
        tvEmpContact = findViewById(R.id.tvContact3)


        setValues()

    }

    private fun setValues(){
        tvEmpId.text = intent.getStringExtra("empId")
        tvEmpName.text = intent.getStringExtra("empUsername")
        tvJob.text = intent.getStringExtra("empJob")
        tvEmpLikedin.text = intent.getStringExtra("empLinkedIn")
        tvEmpContact.text = intent.getStringExtra("empContact")




    }
}