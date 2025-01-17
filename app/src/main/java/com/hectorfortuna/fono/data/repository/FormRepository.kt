package com.hectorfortuna.fono.data.repository

import com.hectorfortuna.fono.data.model.FormModelBody

interface FormRepository {
    suspend fun postData(formModel: FormModelBody): Result<String>
}