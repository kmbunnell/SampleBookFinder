package com.bonehill.samplebookfinder.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bonehill.samplebookfinder.R
import com.bonehill.samplebookfinder.data.Book
import com.bumptech.glide.Glide

class BookListAdapter(private val bookList: List<Book>): RecyclerView.Adapter<BookListAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.txtTitle)
        val coverView: ImageView = view.findViewById(R.id.imgCover)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = bookList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = bookList[position]
        holder.titleView.text = item.volumeInfo.title
        Glide.with(holder.itemView.context)
            .load(item.volumeInfo.imageLinks.thumbnail)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken)
            .fallback(R.drawable.ic_unavailable)
            .into(holder.coverView)

    }
}