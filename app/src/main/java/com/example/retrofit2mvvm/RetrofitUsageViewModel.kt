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

    var getPostsLiveData : MutableLiveData<Response<Post>> = MutableLiveData()
    var getUserPostsParamLiveData : MutableLiveData<Response<Post>> = MutableLiveData()
    var pushPostBodyParamLiveData : MutableLiveData<Response<Post>> = MutableLiveData()
    var pushPostFieldsParamLiveData : MutableLiveData<Response<Post>> = MutableLiveData()
    var pushPostStaticHeaderLiveData : MutableLiveData<Response<Post>> = MutableLiveData()
    var pushPostDynamicHeaderLiveData : MutableLiveData<Response<Post>> = MutableLiveData()
    var getUserPostsQueryParamListLiveData : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    var getUserPostsQueryParam2ListLiveData : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    var getUserPostsQueryMapListLiveData : MutableLiveData<Response<List<Post>>> = MutableLiveData()


    fun getPosts(){

        GlobalScope.launch(Dispatchers.IO) {
            //val response : Response<Post> = repository.getPosts()
            getPostsLiveData.postValue(repository.getPosts())
        }
    }

    fun getUserPostsParam(postNumber:Int){
        GlobalScope.launch(Dispatchers.IO) {
            val response : Response<Post> = repository.getUserPostsParam(postNumber)
            getUserPostsParamLiveData.postValue(response)
        }
    }

    fun getUserPostsQueryParam(userId:Int){

        GlobalScope.launch(Dispatchers.IO) {

            val response : Response<List<Post>> = repository.getUserPostsQueryParam(userId)
            getUserPostsQueryParamListLiveData.postValue(response)
        }
    }

    fun getUserPostsQueryParam2(userId:Int , Sort:String,Order:String){
        GlobalScope.launch(Dispatchers.IO) {
            val response  : Response<List<Post>> = repository.getUserPostsQueryParam2(userId,Sort,Order)
            getUserPostsQueryParam2ListLiveData.postValue(response)
        }
    }

    fun getUserPostsQueryMap(userId: Int , options:Map<String,String>){
        GlobalScope.launch(Dispatchers.IO) {

            val response : Response<List<Post>> = repository.getUserPostsQueryMap(userId,options)
            getUserPostsQueryMapListLiveData.postValue(response)
        }
    }

    fun pushPostBodyParam(post:Post){
        GlobalScope.launch(Dispatchers.IO) {
            val response: Response<Post> = repository.pushPostBodyParam(post)
            pushPostBodyParamLiveData.postValue(response)

        }
    }

    fun pushPostFieldsParam(userId: Int , id:Int , title:String , body:String){

        GlobalScope.launch(Dispatchers.IO) {
            val response : Response<Post> = repository.pushPostFieldsParam(userId ,id , title , body)
            pushPostFieldsParamLiveData.postValue(response)
        }
    }

    fun pushPostStaticHeader(){

        GlobalScope.launch(Dispatchers.IO) {
            val response : Response<Post> = repository.pushPostStaticHeader()
            pushPostStaticHeaderLiveData.postValue(response)
        }
    }


    fun pushPostDynamicHeader(Key:String){

        GlobalScope.launch(Dispatchers.IO) {
            val response : Response<Post> = repository.pushPostDynamicHeader(Key)
            pushPostDynamicHeaderLiveData.postValue(response)
        }
    }

}