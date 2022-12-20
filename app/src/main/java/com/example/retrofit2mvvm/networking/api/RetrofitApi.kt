package com.example.retrofit2mvvm.networking.api
import com.example.retrofit2mvvm.repository.model.Post
import retrofit2.Response
import retrofit2.http.*

interface RetrofitApi {

    //Simple Get Request
    @GET("/posts/1")
    suspend fun getPost ():Response<Post>
    //Adding Path Parameters
    @GET("/posts/{postNumber}")
    suspend fun getPost2 (@Path("postNumber")number : Int):Response<Post>
    //Adding Query Parameters
    @GET("/posts")
    suspend fun getUserPosts(@Query("userId")User:Int) : Response<List<Post>>

    //Adding Query Parameters
    @GET("/posts")
    suspend fun getUserPostsSortedOrdered(
        @Query("userId")User:Int,
        @Query("_sort")sort:String,
        @Query("_order")order:String
    ) : Response<List<Post>>

    //Adding QueryMap
    @GET("/posts")
    suspend fun getUsersPostsQueryMap(
        @Query("userId")User: Int,
        @QueryMap options: Map<String,String>
    ):Response<List<Post>>

    //Post Request Data
    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ):Response<Post>

    // Post With Fields And URL Encode
    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost2(
        @Field("userId")userId:Int,
        @Field("id")id:Int,
        @Field("title")title:String,
        @Field("body")body:String

    ):Response<Post>

    //Add Static Header
    @FormUrlEncoded
    @Headers("AuthKey:123456789")
    @POST("posts")
    suspend fun PostWithStaticHeader():Response<Post>

    //Add Dynamic Headers
    @FormUrlEncoded
    @POST
    suspend fun PostDynamicHeaders(@Header("Authorization-Key")AuthKey:String):Response<Post>
}