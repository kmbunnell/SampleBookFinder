package com.bonehill.samplebookfinder.booksearch

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import com.bonehill.samplebookfinder.R
import com.bonehill.samplebookfinder.adapter.BookGridAdapter
import com.bonehill.samplebookfinder.databinding.BookSearchFragmentBinding

class BookSearch : Fragment() {

    companion object {
        fun newInstance() = BookSearch()
    }

    private val viewModel: BookSearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = BookSearchFragmentBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.viewModel = viewModel
        binding.lifecycleOwner=this
        binding.recyclerView.adapter= BookGridAdapter()
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

        return binding.root
    }


    private fun doSearch(searchWord:String)
    {
        if(searchWord.isNotEmpty()) {
           view?.hideKeyboard()
            viewModel.loadBooks(searchWord)
        }
    }

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

}