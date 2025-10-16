package com.zhogin.healtyscore.di

import com.zhogin.healtyscore.data.remote.AppHttpClient
import com.zhogin.healtyscore.data.remote.OpenFoodFactsDataSource
import com.zhogin.healtyscore.data.remote.RemoteDataSource
import com.zhogin.healtyscore.data.repository.ProductDetailsRepositoryImpl
import com.zhogin.healtyscore.domain.repository.ProductDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesHttpClient(httpClient: AppHttpClient): HttpClient = httpClient.getHttpClient()

    @Provides
    @Singleton
    fun providesRemoteDateSource(impl: OpenFoodFactsDataSource) : RemoteDataSource = impl

    @Provides
    @Singleton
    fun providesProductDetailsRepository(impl: ProductDetailsRepositoryImpl): ProductDetailsRepository = impl
}