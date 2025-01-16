package com.hectorfortuna.fono.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hectorfortuna.fono.model.FormModelBody
import com.hectorfortuna.fono.repository.FormRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(private val repository: FormRepository) : ViewModel() {

    var patientName by mutableStateOf("")
    var patientAge by mutableStateOf("")
    var birthDate by mutableStateOf(0L)
    var fatherName by mutableStateOf("")
    var motherName by mutableStateOf("")
    var career by mutableStateOf("")
    var address by mutableStateOf("")
    var phone by mutableStateOf("")

    fun sendFormData() {
        viewModelScope.launch {
            try {
                val formModel = FormModelBody(
                    patientName = patientName,
                    patientAge = patientAge,
                    birthDate = birthDate,
                    fatherName = fatherName,
                    motherName = motherName,
                    career = career,
                    address = address,
                    phone = phone
                )

                val result = repository.postData(formModel)
                result.onSuccess {
                    println("Dados enviados com sucesso: $it")
                }.onFailure {
                    println("Erro ao enviar os dados: ${it.message}")
                }
            } catch (e: Exception) {
                println("Erro inesperado: ${e.message}")
            }
        }
    }
}