package com.hectorfortuna.fono.data.repository

import com.hectorfortuna.fono.data.model.FormModelBody
import com.hectorfortuna.fono.data.remote.KtorRemoteDataSource
import javax.inject.Inject

class FormRepositoryImpl @Inject constructor (private val remoteDataSource: KtorRemoteDataSource) :
    FormRepository {
    override suspend fun postData(formModel: FormModelBody): Result<String> =
        remoteDataSource.postData(formModel)
}