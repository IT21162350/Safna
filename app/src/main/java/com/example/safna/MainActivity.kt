package com.example.safna

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

private lateinit var addJobBtn: Button;
private lateinit var addEmpBtn: Button;
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addJobBtn = findViewById(R.id.btnPostJonb);
        addJobBtn.setOnClickListener(){
            val employer = Intent(this, employer::class.java)
            startActivity(employer)
        }

        addEmpBtn = findViewById(R.id.regEmp);
        addEmpBtn.setOnClickListener(){
            val addEmployer = Intent(this, addEmp::class.java);
            startActivity(addEmployer);
        }
    }
}