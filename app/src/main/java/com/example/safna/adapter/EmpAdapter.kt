package com.example.safna.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.safna.R
import com.example.safna.activites.empList
import com.example.safna.models.EmpModel

class EmpAdapter (private val EmpList: ArrayList<EmpModel>): RecyclerView.Adapter<EmpAdapter.ViewHolder>(){

    private lateinit var mListner: onItemClickListner

    interface onItemClickListner{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickLister(clickListner: onItemClickListner){
        mListner = clickListner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.emp_list_layout, parent, false)
        return ViewHolder(itemView, mListner)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curruntEmp = EmpList[position]
        holder.tvEmployer.text = curruntEmp.Username
    }


    override fun getItemCount(): Int {
        return EmpList.size
    }

    class ViewHolder(itemView: View, clickListner: onItemClickListner): RecyclerView.ViewHolder(itemView) {
        val tvEmployer: TextView = itemView.findViewById(R.id.EmpName)
        init {
            itemView.setOnClickListener{
                clickListner.onItemClick(adapterPosition)
            }
        }
    }

}