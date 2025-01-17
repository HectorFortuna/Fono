package com.hectorfortuna.fono.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hectorfortuna.fono.data.model.FormModelBody
import com.hectorfortuna.fono.data.repository.FormRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(private val repository: FormRepository) : ViewModel() {

    var patientName by mutableStateOf("")
    var patientAge by mutableStateOf("")
    var birthDate by mutableStateOf("")
    var fatherName by mutableStateOf("")
    var motherName by mutableStateOf("")
    var career by mutableStateOf("")
    var address by mutableStateOf("")
    var phone by mutableStateOf("")

    var patientNameError by mutableStateOf(false)
    var patientAgeError by mutableStateOf(false)
    private var birthDateError by mutableStateOf(false)
    var addressError by mutableStateOf(false)
    var phoneError by mutableStateOf(false)

    private fun validateFields(): Boolean {
        var isValid = true

        patientNameError = patientName.isBlank()
        patientAgeError = patientAge.isBlank()
        birthDateError = birthDate.isBlank()
        addressError = address.isBlank()
        phoneError = phone.isBlank()

        if (patientNameError || patientAgeError || birthDateError || addressError || phoneError
        ) {
            isValid = false
        }

        return isValid
    }

    fun sendFormData() {
        if (!validateFields()) {
            println("Por favor, preencha todos os campos obrigatórios.")
            return
        }

        viewModelScope.launch {
            try {
                val formModel = FormModelBody(
                    patientName = patientName,
                    patientAge = patientAge,
                    birthDate = birthDate, // Já está no formato de string
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