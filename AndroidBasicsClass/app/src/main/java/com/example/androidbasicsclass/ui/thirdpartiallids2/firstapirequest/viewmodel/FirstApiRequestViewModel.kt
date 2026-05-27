package com.example.androidbasicsclass.ui.thirdpartiallids2.firstapirequest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidbasicsclass.ui.thirdpartiallids2.firstapirequest.model.Student
import com.example.androidbasicsclass.ui.thirdpartiallids2.firstapirequest.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FirstApiRequestViewModel : ViewModel() {

    private val _students = MutableStateFlow<List<Student>>(emptyList())
    val students: StateFlow<List<Student>> = _students.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        fetchStudents()
    }

    private fun fetchStudents() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                val response = RetrofitClient.gistService.getStudents()
                _students.value = response.students
            } catch (e: Exception) {
                _error.value = e.message ?: "Error querido"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
