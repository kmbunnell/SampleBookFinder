package com.bonehill.samplebookfinder

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
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

        binding.btnSearch.setOnClickListener {

            val p=binding.txtSearch.text.toString()
            hideKeyboard()
            if(p.length>0)
                viewModel.loadBooks(p)

        }

    }

    fun Activity.hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}