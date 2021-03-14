package com.example.breakingbadcharacters.injection.module

import com.example.breakingbadcharacters.AppConstants
import com.example.networkmodule.data.service.RxApiService
import com.tbruyelle.rxpermissions.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

import timber.log.Timber
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpBuilder.interceptors()
                .add(httpLoggingInterceptor)
        }
        return httpBuilder.build()
    }

    @Provides
    @Singleton
    @Named(AppConstants.RX_RETROFIT)
    internal fun provideRxRestAdapter(okHttpClient: OkHttpClient): Retrofit {
        Timber.e("We are here")
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideRxApiService(@Named(AppConstants.RX_RETROFIT) restAdapter: Retrofit): RxApiService {
        return restAdapter.create(RxApiService::class.java)
    }
}
