package com.hectorfortuna.fono.model

import kotlinx.serialization.Serializable

@Serializable
data class FormModelBody(
    var patientName: String,
    var patientAge: String,
    var birthDate: Long,
    var fatherName: String,
    var motherName: String,
    var career: String,
    var address: String,
    var phone: String
)


