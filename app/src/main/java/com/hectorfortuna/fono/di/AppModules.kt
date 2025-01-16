package com.hectorfortuna.fono.di

import com.hectorfortuna.fono.remote.KtorRemoteDataSource
import com.hectorfortuna.fono.remote.RemoteDataSource
import com.hectorfortuna.fono.repository.FormRepository
import com.hectorfortuna.fono.repository.FormRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModules {
    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(Logging) {
                logger = Logger.SIMPLE
            }
            install(ContentNegotiation) {
                json(Json { prettyPrint = true; isLenient = true })
            }
        }
    }

    @Provides
    fun provideRemoteDataSource(httpClient: HttpClient): RemoteDataSource {
        return KtorRemoteDataSource(httpClient)
    }

    @Provides
    @Singleton
    fun providesFormRepository(
        remoteDataSource: KtorRemoteDataSource
    ): FormRepository = FormRepositoryImpl(remoteDataSource)
}