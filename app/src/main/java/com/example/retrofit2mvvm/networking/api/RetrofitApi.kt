package com.example.retrofit2mvvm.networking.api
import com.example.retrofit2mvvm.repository.model.Post
import retrofit2.Response
import retrofit2.http.*

interface RetrofitApi {

    //Simple Get Request
    @GET("/posts/1")
    suspend fun getPosts ():Response<Post>

    //Get Request Adding Path Parameters
    @GET("/posts/{postNumber}")
    suspend fun getPostsPathParam (@Path("postNumber")number : Int):Response<Post>

    //Get Request Adding Query Parameters
    @GET("/posts")
    suspend fun getPostsQueryParam(@Query("userId")User:Int) : Response<List<Post>>

    //Get Request Adding Query Parameters
    @GET("/posts")
    suspend fun getPostsQueryParam2(
        @Query("userId")User:Int,
        @Query("_sort")sort:String,
        @Query("_order")order:String
    ) : Response<List<Post>>

    //Get Request Adding QueryMap
    @GET("/posts")
    suspend fun getPostsQueryMap(
        @Query("userId")User: Int,
        @QueryMap options: Map<String,String>
    ):Response<List<Post>>

    //Simple Post Request Adding Body Param
    @POST("posts")
    suspend fun pushPostBodyParam(
        @Body post: Post
    ):Response<Post>

    // Post Request  With Fields And URL Encode
    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPostFieldsParam(
        @Field("userId")userId:Int,
        @Field("id")id:Int,
        @Field("title")title:String,
        @Field("body")body:String

    ):Response<Post>

    //Post Request Add Static Header
    @FormUrlEncoded
    @Headers("AuthKey:123456789") // We Type theKey:theValue in the () as Example
    @POST("posts")
    suspend fun pushPostWithStaticHeader():Response<Post>

    //Post Request Add Dynamic Headers
    @FormUrlEncoded
    @POST
    suspend fun pushPostDynamicHeaders(@Header("Authorization-Key")AuthKey:String):Response<Post>


}