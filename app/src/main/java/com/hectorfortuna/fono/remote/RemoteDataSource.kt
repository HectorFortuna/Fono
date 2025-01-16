package com.hectorfortuna.fono.remote

import com.hectorfortuna.fono.model.FormModelBody

interface RemoteDataSource {
    suspend fun postData(formModel: FormModelBody): Result<String>
}