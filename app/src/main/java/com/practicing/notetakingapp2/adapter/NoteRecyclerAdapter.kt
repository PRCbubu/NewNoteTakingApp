package com.practicing.notetakingapp2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.practicing.notetakingapp2.databinding.NoteLayoutBinding
import com.practicing.notetakingapp2.model.NoteEntity

class NoteRecyclerAdapter: RecyclerView.Adapter<NoteRecyclerAdapter.NoteViewHolder>()
{
    class NoteViewHolder(val itemBinding: NoteLayoutBinding): RecyclerView.ViewHolder(itemBinding.root)
        private var differCallback = object : DiffUtil.ItemCallback<NoteEntity>()
        {
            override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
                return oldItem.id == newItem.id && oldItem.noteTitle == newItem.noteTitle && oldItem.noteBody == newItem.noteBody
            }
            override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
                return oldItem == newItem
            }
        }
        val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(NoteLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}