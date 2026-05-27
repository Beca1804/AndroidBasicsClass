package com.example.androidbasicsclass.ui.thirdpartiallids2.firstapirequest.network

import com.example.androidbasicsclass.ui.thirdpartiallids2.firstapirequest.model.StudentsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GistService {

    @GET("ingjromo/5f3c4549cfc64984c9131112fd87d718/raw/6e36ceff88f29b046f2d8529041526a05b8b3dde/students26.json")
    suspend fun getStudents(): StudentsResponse
}

object RetrofitClient {

    val gistService: GistService = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GistService::class.java)
}