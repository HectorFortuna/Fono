package com.hectorfortuna.fono.data.model

import kotlinx.serialization.Serializable

@Serializable
data class FormModelBody(
    var patientName: String,
    var patientAge: String,
    var birthDate: String,
    var fatherName: String,
    var motherName: String,
    var career: String,
    var address: String,
    var phone: String
)


