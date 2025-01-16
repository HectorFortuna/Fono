package com.hectorfortuna.fono.repository

import com.hectorfortuna.fono.model.FormModelBody

interface FormRepository {
    suspend fun postData(formModel: FormModelBody): Result<String>
}