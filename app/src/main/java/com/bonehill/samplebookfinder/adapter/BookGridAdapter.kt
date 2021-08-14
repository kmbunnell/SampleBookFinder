package com.bonehill.samplebookfinder.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bonehill.samplebookfinder.R
import com.bonehill.samplebookfinder.data.Book
import com.bonehill.samplebookfinder.databinding.ItemLayoutBinding
import com.bumptech.glide.Glide

class BookGridAdapter: ListAdapter<Book, BookGridAdapter.BooksViewHolder>(DiffCallback) {


    class BooksViewHolder(
        private var binding: ItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
           binding.bookItem=book
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.volumeInfo.imageLinks.thumbnail == newItem.volumeInfo.imageLinks.thumbnail
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BooksViewHolder {
        return BooksViewHolder(
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }


}