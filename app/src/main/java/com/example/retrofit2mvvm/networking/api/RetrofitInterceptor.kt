package com.example.retrofit2mvvm.networking.api

import okhttp3.Interceptor
import okhttp3.Response


class RetrofitInterceptor : Interceptor {
    //Here We made interceptor to add headers to request
    // Adding headers here will be assigned with each reqest
    override fun intercept(chain: Interceptor.Chain): Response {
        val  request  = chain.request()
            .newBuilder()
            .addHeader("Authorization-Key","123456789")
            .build()
        return chain.proceed(request)
    }
}