package com.example.students

import Student
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.students.model.Model

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val saveButton: Button = findViewById(R.id.add_student_activity_save_button)
        val cancelButton: Button = findViewById(R.id.add_student_activity_cancel_button)

        saveButton.setOnClickListener(::onSave)
        cancelButton.setOnClickListener(::onCancel)
    }

    private fun onSave(view: View) {
        val nameTextField: EditText = findViewById(R.id.add_student_activity_name_edit_text)
        val idTextField: EditText = findViewById(R.id.add_student_activity_id_edit_text)
        val phoneTextField: EditText = findViewById(R.id.add_student_activity_phone_edit_text)
        val addressTextField: EditText = findViewById(R.id.add_student_activity_address_edit_text)
        val checkedTextField: CheckBox = findViewById(R.id.add_student_activity_checked_checkbox)

        val name = nameTextField.text.toString()
        val id = idTextField.text.toString()
        val phone = phoneTextField.text.toString()
        val address = addressTextField.text.toString()
        val isChecked = checkedTextField.isChecked

        val student = Student(name, id, phone, address, isChecked)
        Model.shared.students.add(student)

        finish()
    }

    private fun onCancel(view: View) {
        finish()
    }
}