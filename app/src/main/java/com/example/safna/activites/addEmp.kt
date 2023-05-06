package com.example.safna.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.safna.models.EmpModel
import com.example.safna.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

private lateinit var etUsername: EditText
private lateinit var etEmail: EditText
private lateinit var etlinkedin: EditText
private lateinit var etJob: EditText
private lateinit var etTelNo: EditText
private lateinit var btnSave: Button


class addEmp : AppCompatActivity() {

    private lateinit var dbRef:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_emp)


        etUsername = findViewById(R.id.txtUsername)
        etEmail = findViewById(R.id.txtEmail)
        etlinkedin = findViewById(R.id.txtlinkedin)
        etJob = findViewById(R.id.txtJob)
        etTelNo = findViewById(R.id.txtTelno)
        btnSave = findViewById(R.id.btnSave)

        dbRef = FirebaseDatabase.getInstance().getReference("Employer")


        btnSave.setOnClickListener(){
            saveEmployer()
        }

    }
    private fun saveEmployer(){
         val Username = etUsername.text.toString()
         val Email = etEmail.text.toString()
         val Linkedin = etlinkedin.text.toString()
         val Job = etJob.text.toString()
         val Telno = etTelNo.text.toString()

        if(Username.isEmpty()){
            etUsername.error="Please enter name"
        }
        if(Email.isEmpty()){
            etEmail.error="Please enter email"
        }
        if(Linkedin.isEmpty()){
            etlinkedin.error="Please enter linkedin"
        }
        if(Job.isEmpty()){
            etJob.error="Please enter job"
        }
        if(Telno.isEmpty()){
            etTelNo.error="Please enter tel no"
        }
        else {
            val empId = dbRef.push().key

            val employer = EmpModel(Username, Email, Linkedin, Job, Telno)

            if (empId != null) {
                dbRef.child(empId).setValue(employer).addOnCompleteListener {
                    Toast.makeText(this, "Data inserted Successfully", Toast.LENGTH_LONG).show()

                }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error in data inserted!", Toast.LENGTH_LONG).show()
                    }
            }

        }
    }
}