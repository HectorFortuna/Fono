package com.hectorfortuna.fono.data.remote

import com.hectorfortuna.fono.data.model.FormModelBody

interface RemoteDataSource {
    suspend fun postData(formModel: FormModelBody): Result<String>
}