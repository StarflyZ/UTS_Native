package com.cerbung.a160421041_160421132_160821028

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cerbung.a160421041_160421132_160821028.databinding.ReadItemBinding

class ParagraphAdapter(private val id: Int) : RecyclerView.Adapter<ParagraphAdapter.ParagraphViewHolder>(){
    class ParagraphViewHolder(val binding: ReadItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParagraphViewHolder {
        val binding = ReadItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParagraphViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Global.paragraph.size
    }

    override fun onBindViewHolder(holder: ParagraphViewHolder, position: Int) {
        val paragraph = Global.paragraph[position].text
        val author = Global.paragraph[position].author
        val paragraphId = Global.paragraph[position].id

        if (paragraphId == id) {
            holder.binding.txtParagraph.text = paragraph
            holder.binding.txtAuthor.text = author
        } else {
            holder.itemView.layoutParams.height = 0
        }
    }
}