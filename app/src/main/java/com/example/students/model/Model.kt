package com.example.students.model

import Student

class Model private constructor() {
    val students = mutableListOf<Student>()

    companion object {
        val shared = Model()
    }
}