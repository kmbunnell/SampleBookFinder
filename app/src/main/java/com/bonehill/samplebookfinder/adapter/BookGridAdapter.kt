package com.bonehill.samplebookfinder.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bonehill.samplebookfinder.data.Book
import com.bonehill.samplebookfinder.databinding.CardItemBinding


class BookGridAdapter: ListAdapter<Book, BookGridAdapter.BooksViewHolder>(DiffCallback) {

    inner class BooksViewHolder(
        private var binding: CardItemBinding//ItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {
                binding.bookItem?.let { book ->
                    addBookToMyList(book)
                }
            }
        }

        fun bind(book: Book) {
           binding.bookItem=book
            binding.executePendingBindings()
        }

        fun addBookToMyList(book:Book)
        {
            Log.d("BOOK", "clicked book "+book.volumeInfo.title)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.volumeInfo.imageLinks?.thumbnail == newItem.volumeInfo.imageLinks?.thumbnail
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BooksViewHolder {
        val binding = CardItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return BooksViewHolder(binding)

    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val book = getItem(position)
        holder.bind(book)
    }


}