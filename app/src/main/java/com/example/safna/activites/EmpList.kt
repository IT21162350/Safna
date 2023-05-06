package com.example.safna.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.safna.R
import com.example.safna.adapter.EmpAdapter
import com.example.safna.models.EmpModel
import com.google.firebase.database.*

class empList : AppCompatActivity() {

    private lateinit var empRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var empList: ArrayList<EmpModel>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emp_list)

        empRecyclerView = findViewById(R.id.empList)
        empRecyclerView.layoutManager = LinearLayoutManager(this)
        empRecyclerView.setHasFixedSize(true)

        tvLoadingData = findViewById(R.id.tvLoadingDataEmp)

        empList = arrayListOf<EmpModel>()

        getEmployerData()

    }

    private fun getEmployerData(){
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("Employer")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(EmpModel::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = EmpAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickLister(object : EmpAdapter.onItemClickListner{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@empList, employer::class.java)

                            //
                            intent.putExtra("empId", empList[position].Email)
                            intent.putExtra("empJob", empList[position].Job)
                            intent.putExtra("empUsername", empList[position].Username)
                            intent.putExtra("empContact", empList[position].Telno)
                            intent.putExtra("empLinkedIn", empList[position].Linkedin)

                            startActivity(intent)
                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}