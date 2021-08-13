package com.bonehill.samplebookfinder.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonehill.samplebookfinder.data.Book

import com.bonehill.samplebookfinder.api.BookSeach
import kotlinx.coroutines.launch

class MainActivityViewModel :ViewModel() {


    val books: MutableLiveData<List<Book>> by lazy {
        MutableLiveData<List<Book>>()
    }

        init {
            loadBooks()
        }

        private fun loadBooks() {
            viewModelScope.launch {
                try {
                    val response  = BookSeach.retrofitService.getBooksByTitle()
                    if ( !response.items.isEmpty())
                        books.value = response.items
                } catch (e: Exception){
                     Log.e("MainActivityViewModel", e.message.toString());
                }
            }
        }
}