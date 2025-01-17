package com.hectorfortuna.fono.data.remote

import com.hectorfortuna.fono.data.model.FormModelBody
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import javax.inject.Inject

class KtorRemoteDataSource @Inject constructor(private val httpClient: HttpClient) :
    RemoteDataSource {
    companion object {
        private const val BASE_URL = "http://192.168.15.10:8080/api"
    }

    override suspend fun postData(formModel: FormModelBody): Result<String> {
        return try {
            val response: HttpResponse = httpClient.post("$BASE_URL/register") {
                contentType(io.ktor.http.ContentType.Application.Json)
                setBody(formModel)
            }

            if (response.status == HttpStatusCode.OK) {
                Result.success("Sucesso: ${response.status}")
            } else {
                Result.failure(Exception("Erro: ${response.status}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}