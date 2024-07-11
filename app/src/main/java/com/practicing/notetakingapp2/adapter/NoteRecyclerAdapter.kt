package com.practicing.notetakingapp2.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.practicing.notetakingapp2.databinding.NoteLayoutBinding
import com.practicing.notetakingapp2.model.NoteEntity
import kotlin.random.Random

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
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = differ.currentList[position]

        holder.itemBinding.tvNoteTitle.text = currentNote.noteTitle
        holder.itemBinding.tvNoteBody.text = currentNote.noteBody

        val random = Random()
        val color = Color.argb(256, random.nextInt(256), random.nextInt(256), random.nextInt(256))
        holder.itemBinding.ibColor.setBackgroundColor(color)
        holder.itemView.setOnClickListener {
            val direction = NoteFragmentDirections.actionNoteFragmentToUpdateNoteFragment(currentNote)
        }

    }
}