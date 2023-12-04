package com.cerbung.a160421041_160421132_160821028

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cerbung.a160421041_160421132_160821028.databinding.CerbungItemBinding
import com.squareup.picasso.Picasso

class CerbungAdapter(private val user: String):RecyclerView.Adapter<CerbungAdapter.CerbungViewHolder>(){
    class CerbungViewHolder(val binding: CerbungItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CerbungViewHolder {
        val binding = CerbungItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CerbungViewHolder(binding)
    }

    override fun getItemCount():Int {
        return Global.cerbungs.size
    }

    override fun onBindViewHolder(holder: CerbungViewHolder, position: Int) {
        val url = Global.cerbungs[position].url
        with(holder.binding){
            val builder = Picasso.Builder(holder.itemView.context)
            builder.listener {picasso, url, exception -> exception.printStackTrace()}
            builder.build().load(url).into(imgPoster)
            txtTitle.text = Global.cerbungs[position].title
            txtSub.text = Global.cerbungs[position].subHead
            txtDesc.text = Global.cerbungs[position].desc

            val user = user

            btnRead.setOnClickListener {
                val cerbung = Global.cerbungs[position]
                val intent = Intent(holder.itemView.context, if (cerbung.access == "Restricted") RestrictedReadActivity::class.java else PublicReadActivity::class.java)

                intent.putExtra("id", cerbung.id)
                intent.putExtra("title", cerbung.title)
                intent.putExtra("subHead", cerbung.subHead)
                intent.putExtra("imageUrl", cerbung.url)
                intent.putExtra("genre", cerbung.genre)
                intent.putExtra("access", cerbung.access)
                intent.putExtra("user", user)

                holder.itemView.context.startActivity(intent)
//                if (cerbung.access === "Restricted")
//                {
//                    val intent = Intent(holder.itemView.context, RestrictedReadActivity::class.java)
//                    intent.putExtra("id", cerbung.id)
//                    intent.putExtra("title", cerbung.title)
//                    intent.putExtra("subHead", cerbung.subHead)
//                    intent.putExtra("imageUrl", cerbung.url)
//                    intent.putExtra("genre", cerbung.genre)
//                    intent.putExtra("access", cerbung.access)
//                    intent.putExtra("user", user)
//
//                    holder.itemView.context.startActivity(intent)
//                }
//                else if  (cerbung.access === "Public")
//                {
//                    val intent = Intent(holder.itemView.context, PublicReadActivity::class.java)
//                    intent.putExtra("id", cerbung.id)
//                    intent.putExtra("title", cerbung.title)
//                    intent.putExtra("subHead", cerbung.subHead)
//                    intent.putExtra("imageUrl", cerbung.url)
//                    intent.putExtra("genre", cerbung.genre)
//                    intent.putExtra("access", cerbung.access)
//                    intent.putExtra("user", user)
//
//                    holder.itemView.context.startActivity(intent)
//                }
            }
        }
    }
}