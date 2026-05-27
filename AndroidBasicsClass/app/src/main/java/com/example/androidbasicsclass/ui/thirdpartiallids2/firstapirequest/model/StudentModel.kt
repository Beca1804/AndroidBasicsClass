package com.example.androidbasicsclass.ui.thirdpartiallids2.firstapirequest.model

data class Student(
    val name: String,
    val studentId: String,
    val hobby: String,
    val photoUrl: String
)

data class StudentsResponse(
    val students: List<Student>
)
