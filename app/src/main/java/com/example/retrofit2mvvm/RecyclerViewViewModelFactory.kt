package com.example.retrofit2mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit2mvvm.repository.Repository

class RecyclerViewViewModelFactory (private val repository: Repository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return RecyclerViewViewModel(repository) as T
    }
}