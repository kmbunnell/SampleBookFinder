package com.bonehill.samplebookfinder.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonehill.samplebookfinder.data.Book

import com.bonehill.samplebookfinder.api.BookSearch
import kotlinx.coroutines.launch

class MainActivityViewModel :ViewModel() {


    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    fun loadBooks(title:String) {
        viewModelScope.launch {
            try {
                val response = BookSearch.retrofitService.getBooksByTitle(title)
                if (!response.items.isEmpty())
                    _books.value = response.items
            } catch (e: Exception) {
                Log.e("MainActivityViewModel", e.message.toString())
                _books.value = listOf()
            }
        }
    }
}