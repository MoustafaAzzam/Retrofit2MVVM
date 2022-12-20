package com.example.retrofit2mvvm.networking.api

import com.example.retrofit2mvvm.networking.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private val retrofit by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val api : RetrofitApi by lazy {
        retrofit.create(RetrofitApi::class.java)
    }

    // Retrofit Instance With Interceptor

    //Defining Client with interceptor to Enable Headers adding for request
    private val client= OkHttpClient.Builder().apply {
        addInterceptor(RetrofitInterceptor())
    }.build()


    private val retrofitWithInterceptor by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val apiWithInterceptor : RetrofitApi by lazy {
     retrofitWithInterceptor.create(RetrofitApi::class.java)
    }


    /*Another way for Creating Retrofit API */

/*      fun <Api>buildAPI(
           api : Class<Api>
       ){
           return Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
               .create()
       }
*/

}