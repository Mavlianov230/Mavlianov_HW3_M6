package com.example.mavlianov_hw3_m6.ui.theme.Data.ServiceLocator

import com.example.Mavlianov_hw3_m6.BuildConfig
import com.example.mavlianov_hw3_m6.ui.theme.Data.Api.CharacterApiService
import com.example.mavlianov_hw3_m6.ui.theme.Data.Api.EpisodeApiService
import com.example.mavlianov_hw3_m6.ui.theme.Data.Api.LocationApiService
import com.example.mavlianov_hw3_m6.ui.theme.Data.Repository.CharacterRepository
import com.example.mavlianov_hw3_m6.ui.theme.Data.Repository.EpisodeRepository
import com.example.mavlianov_hw3_m6.ui.theme.Data.Repository.LocationRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataModul = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { get<Retrofit>().create(CharacterApiService::class.java) }
    single { get<Retrofit>().create(EpisodeApiService::class.java) }
    single { get<Retrofit>().create(LocationApiService::class.java) }
    single { CharacterRepository(get()) }
    single { EpisodeRepository(get()) }
    single { LocationRepository(get()) }
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}
