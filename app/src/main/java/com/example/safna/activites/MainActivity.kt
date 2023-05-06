package com.example.safna.activites

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.safna.R

private lateinit var addJobBtn: Button;
private lateinit var addEmpBtn: Button;
private lateinit var btnEmpList: Button
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addJobBtn = findViewById(R.id.btnPostJonb)
        addEmpBtn = findViewById(R.id.regEmp)
        btnEmpList = findViewById(R.id.btnEmpList)


        addJobBtn.setOnClickListener(){
            val employer = Intent(this, employer::class.java);
            startActivity(employer)
        }

        addEmpBtn.setOnClickListener(){
            val addEmployer = Intent(this, addEmp::class.java)
            startActivity(addEmployer)
        }

        btnEmpList.setOnClickListener(){
            val empList = Intent(this, empList::class.java)
            startActivity(empList)
        }

    }
}