package com.example.retrofit2mvvm.repository.model

import com.google.gson.annotations.SerializedName

data class Post (

    @SerializedName("userId")// Add Serialized to define the name Same As Json Response
    val user : String ,
    val id : String, // Here we don't need to add serialized as this as Json Response
    @SerializedName("title")// Add Serialized to define the name Same As Json Response
    val PostTitle : String ,
    @SerializedName("body") // Add Serialized to define the name Same As Json Response
    val PostBody : String

)
