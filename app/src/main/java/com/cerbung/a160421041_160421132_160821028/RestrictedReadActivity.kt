package com.cerbung.a160421041_160421132_160821028

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityRestrictedReadBinding
import com.squareup.picasso.Picasso

class RestrictedReadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRestrictedReadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestrictedReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cerbungId = intent.getIntExtra("id", -1)
        val title = intent.getStringExtra("title")
        val subHead = intent.getStringExtra("subHead")
        val imageUrl = intent.getStringExtra("imageUrl")
        val genre = intent.getStringExtra("genre")
        val access = intent.getStringExtra("access")
//        val paragraphs = intent.getStringArrayListExtra("paragraphs")
//        val authors = intent.getStringArrayListExtra("authors")

        val selectedCerbung = Global.cerbungs.find { it.id == cerbungId }

        binding.txtTitleRestricted.text = title;
        binding.txtAuthorRestricted.text = subHead;
        binding.txtGenreRestricted.text = genre;
        binding.txtAccess.text = access;

        val builder = Picasso.Builder(this)
        builder.listener { picasso, uri, exception -> exception.printStackTrace() }
        builder.build().load(imageUrl).into(binding.imgPosterRestricted)

        val lm = LinearLayoutManager(this)
        binding.recyclerViewRead.layoutManager = lm

        if (selectedCerbung != null) {
            binding.txtTitleRestricted.text = selectedCerbung.title
            binding.txtAuthorRestricted.text = selectedCerbung.subHead

            val builder = Picasso.Builder(this)
            builder.listener { picasso, uri, exception -> exception.printStackTrace() }
            builder.build().load(selectedCerbung.url).into(binding.imgPosterRestricted)

            val lm = LinearLayoutManager(this)
            binding.recyclerViewRead.layoutManager = lm

            // Set adapter untuk menampilkan paragraphs dan authors
            binding.recyclerViewRead.adapter = ParagraphAdapter(selectedCerbung.id)
        }
//        if (paragraphs != null && authors != null) {
//            binding.recyclerViewRead.adapter = ParagraphAdapter(paragraphs, authors)
//        }

//        Log.d("ParagraphAdapter", "Paragraphs: $paragraphs")
//        Log.d("ParagraphAdapter", "Authors: $authors")
    }
}