package com.example.retrofit2mvvm.networking.api

import com.example.retrofit2mvvm.networking.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val client= OkHttpClient.Builder().apply {
        addInterceptor(RetrofitInterceptor())
    }.build()
    // Interceptor For adding Headers
    private val retrofit by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            //.client(client) Adding client
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : AuthenticationApi by lazy {
        retrofit.create(AuthenticationApi::class.java)
    }


    /*  fun <Api>buildAPI(
           api : Class<Api>
       ){
           return Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
               .create()
       }*/

}