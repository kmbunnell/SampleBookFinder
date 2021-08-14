package com.bonehill.samplebookfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bonehill.samplebookfinder.adapter.BookGridAdapter

import com.bonehill.samplebookfinder.databinding.ActivityMainBinding
import com.bonehill.samplebookfinder.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
   // private lateinit var binding: ActivityMainBinding

   private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.recyclerView.adapter=BookGridAdapter()


       /* binding.viewModel = viewmodel

        viewmodel.books.observe(this, Observer { booklist ->
            if (booklist.isNotEmpty()) {
               binding.recyclerView.adapter=BookGridAdapter()
            }
        })*/


    }
}