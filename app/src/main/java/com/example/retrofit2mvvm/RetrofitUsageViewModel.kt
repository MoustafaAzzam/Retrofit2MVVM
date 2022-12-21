package com.example.retrofit2mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit2mvvm.repository.Repository
import com.example.retrofit2mvvm.repository.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class RetrofitUsageViewModel(private val repository: Repository) : ViewModel() {

    var PostRequestLiveData : MutableLiveData<Response<Post>> = MutableLiveData()
    var PostListReuestLiveData : MutableLiveData<Response<List<Post>>> = MutableLiveData()


    fun getPosts(){

        GlobalScope.launch(Dispatchers.IO) {
            //val response : Response<Post> = repository.getPosts()
            PostRequestLiveData.postValue(repository.getPosts())
        }
    }

    fun getUserPostsParam(postNumber:Int){
        GlobalScope.launch(Dispatchers.IO) {
            val response : Response<Post> = repository.getUserPostsParam(postNumber)
            PostRequestLiveData.postValue(response)
        }
    }

    fun getUserPostsQueryParam(userId:Int){

        GlobalScope.launch(Dispatchers.IO) {

            val response : Response<List<Post>> = repository.getUserPostsQueryParam(userId)
            PostListReuestLiveData.postValue(response)
        }
    }

    fun getUserPostsQueryParam2(userId:Int , Sort:String,Order:String){
        GlobalScope.launch(Dispatchers.IO) {
            val response  : Response<List<Post>> = repository.getUserPostsQueryParam2(userId,Sort,Order)
            PostListReuestLiveData.postValue(response)
        }
    }

    fun getUserPostsQueryMap(userId: Int , options:Map<String,String>){
        GlobalScope.launch(Dispatchers.IO) {

            val response : Response<List<Post>> = repository.getUserPostsQueryMap(userId,options)
            PostListReuestLiveData.postValue(response)
        }
    }

    fun pushPostBodyParam(post:Post){
        GlobalScope.launch(Dispatchers.IO) {
            val response: Response<Post> = repository.pushPostBodyParam(post)
            PostRequestLiveData.postValue(response)

        }
    }

    fun pushPostFieldsParam(userId: Int , id:Int , title:String , body:String){

        GlobalScope.launch(Dispatchers.IO) {
            val response : Response<Post> = repository.pushPostFieldsParam(userId ,id , title , body)
            PostRequestLiveData.postValue(response)
        }
    }

    fun pushPostStaticHeader(){

        GlobalScope.launch(Dispatchers.IO) {
            val response : Response<Post> = repository.pushPostStaticHeader()
            PostRequestLiveData.postValue(response)
        }
    }


    fun pushPostDynamicHeader(Key:String){

        GlobalScope.launch(Dispatchers.IO) {
            val response : Response<Post> = repository.pushPostDynamicHeader(Key)
            PostRequestLiveData.postValue(response)
        }
    }

}