package com.bonehill.samplebookfinder.api


import com.bonehill.samplebookfinder.data.BookResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://www.googleapis.com/"
//q=$title&


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL)
    .build()

interface  BookSearchApi {
    @GET("books/v1/volumes?printType=BOOKS&orderBy=newest&maxResults=10&projection=lite&q=rose")
    suspend fun getBooksByTitle(): BookResponse
}

object BookSearch {
    val retrofitService : BookSearchApi by lazy {
        retrofit.create(BookSearchApi::class.java)
    }
}