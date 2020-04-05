package com.example.helloworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.inner_list_item_layout.view.*

class PhotosAdapter(val photosList: MutableList<Photo>) :
    RecyclerView.Adapter<PhotosAdapter.InnerListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerListViewHolder {
        return InnerListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.inner_list_item_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    override fun onBindViewHolder(holder: InnerListViewHolder, position: Int) {

        val photo = photosList[position]
        holder.itemView.descriptionTextView.text = photo.description
        holder.itemView.thumbnailImageView.setImageResource(photo.imageResourceId)
        holder.itemView.removeImageView.setOnClickListener {
            removeItem(position)
        }
    }

    fun removeItem(position: Int) {
        photosList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, photosList.size);
    }

    class InnerListViewHolder : RecyclerView.ViewHolder {
        constructor(itemView: View) : super(itemView)

    }
}