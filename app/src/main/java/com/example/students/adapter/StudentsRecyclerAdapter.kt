package com.example.students.adapter

import Student
import StudentsViewHolder
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.students.R
import com.example.students.StudentDetailsActivity

class StudentsRecyclerAdapter(private val students: MutableList<Student>) : RecyclerView.Adapter<StudentsViewHolder>() {
    override fun getItemCount(): Int = students.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        val inflation = LayoutInflater.from(parent.context)
        val view = inflation.inflate(R.layout.student_row_layout, parent, false)

        return StudentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        holder.bind(students[position], position)

        holder.itemView.apply {
            setOnClickListener {
                val context = it.context
                val intent = Intent(context, StudentDetailsActivity::class.java).apply {
                    putExtra("studentPosition", position)
                }
                context.startActivity(intent)
            }
        }
    }
}