package com.bonehill.samplebookfinder.booklist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bonehill.samplebookfinder.R

class MyBookList : Fragment() {

    companion object {
        fun newInstance() = MyBookList()
    }

    private lateinit var viewModel: MyBookListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_book_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyBookListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}