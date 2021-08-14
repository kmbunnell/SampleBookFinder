package com.bonehill.samplebookfinder

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

import com.bonehill.samplebookfinder.adapter.BookGridAdapter
import com.bonehill.samplebookfinder.data.Book
import com.bumptech.glide.Glide

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Book>?) {
    val adapter = recyclerView.adapter as BookGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    Glide.with(imgView.context)
        .load(imgUrl)
        .placeholder(R.drawable.loading_animation)
        .error(R.drawable.ic_broken)
        .fallback(R.drawable.ic_unavailable)
        .into(imgView)
}