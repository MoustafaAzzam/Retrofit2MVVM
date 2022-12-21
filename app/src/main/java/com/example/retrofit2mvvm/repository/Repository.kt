package com.example.retrofit2mvvm.repository

import com.example.retrofit2mvvm.networking.api.RetrofitInstance
import com.example.retrofit2mvvm.repository.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPosts():Response<Post>{
        return RetrofitInstance.api.getPosts()
    }

    suspend fun getUserPostsParam(postId : Int):Response<Post>{
        return RetrofitInstance.api.getPostsPathParam(postId)
    }

    suspend fun getUserPostsQueryParam(userId: Int):Response<List<Post>>{
        return RetrofitInstance.api.getPostsQueryParam(userId)
    }

    suspend fun getUserPostsQueryParam2(userId: Int , Sort:String, Order:String):Response<List<Post>>{
        return RetrofitInstance.api.getPostsQueryParam2(userId,Sort,Order)
    }

    suspend fun getUserPostsQueryMap(userId: Int, Options:Map<String,String>):Response<List<Post>>{
        return RetrofitInstance.api.getPostsQueryMap(userId,Options)
    }

    suspend fun pushPostBodyParam(userPost:Post):Response<Post>{
        return RetrofitInstance.api.pushPostBodyParam(userPost)
    }

    suspend fun pushPostFieldsParam(userId: Int, id:Int , title:String , body:String):Response<Post>{
        return RetrofitInstance.api.pushPostFieldsParam(userId,id,title,body)
    }

    suspend fun pushPostStaticHeader():Response<Post>{
        return RetrofitInstance.apiWithInterceptor.pushPostWithStaticHeader()
    }
    suspend fun pushPostDynamicHeader(Key:String):Response<Post>{
        return RetrofitInstance.apiWithInterceptor.pushPostDynamicHeaders(Key)
    }


}