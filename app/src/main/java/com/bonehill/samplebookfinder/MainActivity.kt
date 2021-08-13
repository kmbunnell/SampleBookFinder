package com.bonehill.samplebookfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bonehill.samplebookfinder.adapter.BookListAdapter
import com.bonehill.samplebookfinder.databinding.ActivityMainBinding
import com.bonehill.samplebookfinder.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewmodel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel.books.observe(this, Observer { booklist ->
            if (booklist.isNotEmpty()) {
               binding.recyclerView.adapter=BookListAdapter(booklist)
            }
        })


    }
}