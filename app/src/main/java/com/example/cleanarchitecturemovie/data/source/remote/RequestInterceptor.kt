package com.example.cleanarchitecturemovie.data.source.remote

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newUrl = originalRequest.url
            .newBuilder()
            .addQueryParameter(
                "api_key",
                "1afdcc57d6cedfb7a99ba6bea5196a07"
            )
            .build()
        val request = originalRequest.newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(request)
    }
}