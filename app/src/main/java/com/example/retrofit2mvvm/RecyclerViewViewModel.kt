package com.example.retrofit2mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit2mvvm.repository.Repository
import com.example.retrofit2mvvm.repository.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class RecyclerViewViewModel(private val repository: Repository) : ViewModel() {

    var UersPosts : MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun userPostsAll(userId:Int){

        viewModelScope.launch(Dispatchers.IO) {
            val response : Response<List<Post>> = repository.getUserPostsQueryParam(userId)
            UersPosts.postValue(response)
        }
/*
        GlobalScope.launch(Dispatchers.IO) {
            val response : Response<List<Post>> = repository.getUserPostsQueryParam(userId)
            UersPosts.postValue(response)
        }
*/
    }

}