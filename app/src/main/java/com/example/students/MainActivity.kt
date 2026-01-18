package com.example.students

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.students.adapter.StudentsRecyclerAdapter
import com.example.students.model.Model
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var studentsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_activity_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val students = Model.shared.students

        studentsRecyclerView = findViewById(R.id.main_activity_students_recycler_view)
        studentsRecyclerView.setHasFixedSize(true)
        studentsRecyclerView.layoutManager = LinearLayoutManager(this)
        studentsRecyclerView.adapter = StudentsRecyclerAdapter(students)

        val addStudentButton =
            findViewById<FloatingActionButton>(R.id.main_activity_add_student_floating_action_button)
        addStudentButton.setOnClickListener {
            startActivity(Intent(this, AddStudentActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        (studentsRecyclerView.adapter as StudentsRecyclerAdapter).notifyDataSetChanged()
    }
}