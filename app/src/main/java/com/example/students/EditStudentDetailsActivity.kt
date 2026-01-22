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
import kotlin.properties.Delegates

class EditStudentDetailsActivity : AppCompatActivity() {
    private var studentPosition by Delegates.notNull<Int>()
    private lateinit var nameTextField: EditText
    private lateinit var idTextField: EditText
    private lateinit var phoneTextField: EditText
    private lateinit var addressTextField: EditText
    private lateinit var isCheckedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_student_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        studentPosition = intent.getSerializableExtra("studentPosition") as Int
        val student = Model.Companion.shared.students[studentPosition]


        nameTextField = findViewById(R.id.edit_student_details_activity_name_edit_text)
        idTextField = findViewById(R.id.edit_student_details_activity_id_edit_text)
        phoneTextField = findViewById(R.id.edit_student_details_activity_phone_edit_text)
        addressTextField = findViewById(R.id.edit_student_details_activity_address_edit_text)
        isCheckedCheckBox = findViewById(R.id.edit_student_details_activity_checked_checkbox)

        nameTextField.text.append(student.name)
        idTextField.text.append(student.id)
        phoneTextField.text.append(student.phone)
        addressTextField.text.append(student.address)
        isCheckedCheckBox.isChecked = student.isChecked

        val deleteButton = findViewById<Button>(R.id.edit_student_details_activity_delete_button)
        deleteButton.setOnClickListener(::onDelete)

        val cancelButton = findViewById<Button>(R.id.edit_student_details_activity_cancel_button)
        cancelButton.setOnClickListener {
            finish()
        }

        val saveButton = findViewById<Button>(R.id.edit_student_details_activity_save_button)
        saveButton.setOnClickListener(::onSave)
    }

    private fun onDelete(view: View) {
        Model.Companion.shared.students.removeAt(studentPosition)
        finish()
    }

    private fun onSave(view: View) {
        val name = nameTextField.text.toString()
        val id = idTextField.text.toString()
        val phone = phoneTextField.text.toString()
        val address = addressTextField.text.toString()
        val isChecked = isCheckedCheckBox.isChecked

        val student = Student(name, id, phone, address, isChecked)
        Model.Companion.shared.students[studentPosition] = student

        finish()
    }
}