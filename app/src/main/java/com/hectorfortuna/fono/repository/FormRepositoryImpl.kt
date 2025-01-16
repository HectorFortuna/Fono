package com.hectorfortuna.fono.repository

import com.hectorfortuna.fono.model.FormModelBody
import com.hectorfortuna.fono.remote.KtorRemoteDataSource
import javax.inject.Inject

class FormRepositoryImpl @Inject constructor (private val remoteDataSource: KtorRemoteDataSource) : FormRepository {
    override suspend fun postData(formModel: FormModelBody): Result<String> =
        remoteDataSource.postData(formModel)
}