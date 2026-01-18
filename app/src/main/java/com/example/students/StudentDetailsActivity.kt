package com.example.students

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.students.model.Model

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editStudentButton = findViewById<Button>(R.id.student_details_activity_edit_button)
        val cancelButton = findViewById<Button>(R.id.student_details_activity_cancel_button)

        editStudentButton.setOnClickListener(
            {
                // TODO: Edit student
                finish()
            }
        )

        cancelButton.setOnClickListener(
            {
                finish()
            }
        )

        val studentNameTextView =
            findViewById<TextView>(R.id.student_details_activity_name_text_view)
        val studentIdTextView =
            findViewById<TextView>(R.id.student_details_activity_id_text_view)
        val studentAddressTextView =
            findViewById<TextView>(R.id.student_details_activity_address_text_view)
        val studentPhoneTextView =
            findViewById<TextView>(R.id.student_details_activity_phone_text_view)
        val studentCheckedCheckBox =
            findViewById<CheckBox>(R.id.student_details_activity_checked_checkbox)


        val studentPosition = intent.getSerializableExtra("studentPosition") as Int
        val student = Model.shared.students[studentPosition]

        student.let {

            studentNameTextView.text = studentNameTextView.text.toString() + ": " + it.name
            studentIdTextView.text = studentIdTextView.text.toString() + ": " + it.id
            studentPhoneTextView.text = studentPhoneTextView.text.toString() + ": " + it.phone
            studentAddressTextView.text = studentAddressTextView.text.toString() + ": " + it.address
            studentCheckedCheckBox.isChecked = it.isChecked
        }

    }
}