package com.bonehill.samplebookfinder

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import com.bonehill.samplebookfinder.adapter.BookGridAdapter

import com.bonehill.samplebookfinder.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

   private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
       /* val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.recyclerView.adapter=BookGridAdapter()
        binding.txtSearch.setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEND -> {
                    doSearch(binding.txtSearch.text.toString())

                    true
                }
                else -> false
            }
        }

       binding.btnSearch.setOnClickListener {
            doSearch(binding.txtSearch.text.toString())
        }

    }

    private fun doSearch(searchWord:String)
    {
        if(searchWord.isNotEmpty()) {
            hideKeyboard()
            viewModel.loadBooks(searchWord)
        }
    }

    private fun Activity.hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }*/
}