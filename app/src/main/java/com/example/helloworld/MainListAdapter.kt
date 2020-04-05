package com.example.helloworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_list_item_layout.view.*

class MainListAdapter(val documentListItems: MutableList<DocumentModel>) :
    RecyclerView.Adapter<MainListAdapter.MianListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MianListViewHolder {
        return MainListAdapter.MianListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.main_list_item_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return documentListItems.size
    }

    override fun onBindViewHolder(holder: MianListViewHolder, position: Int) {
        val document = documentListItems[position]
        holder.itemView.documentTitle.text = document.description

        val photosRecyclerView = holder.itemView.photosRecyclerView
        if (document.photoList != null && !document.photoList.isEmpty()) {
            photosRecyclerView.layoutManager =
                LinearLayoutManager(holder.itemView.documentTitle.context)
            photosRecyclerView.adapter = PhotosAdapter(document.photoList)
            photosRecyclerView.visibility = View.VISIBLE
        } else {
            photosRecyclerView.visibility = View.GONE
        }

    }

    fun removeInnerItem(innerPosition: Int, outerPosition: Int) {
            documentListItems[outerPosition].photoList.removeAt(innerPosition)
        notifyDataSetChanged()
    }

    class MianListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}
