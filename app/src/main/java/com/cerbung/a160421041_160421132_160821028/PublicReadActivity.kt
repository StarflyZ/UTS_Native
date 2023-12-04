package com.cerbung.a160421041_160421132_160821028

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityPublicReadBinding
import com.squareup.picasso.Picasso

class PublicReadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPublicReadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublicReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cerbungId = intent.getIntExtra("id", -1)
        val title = intent.getStringExtra("title")
        val subHead = intent.getStringExtra("subHead")
        val imageUrl = intent.getStringExtra("imageUrl")
        val genre = intent.getStringExtra("genre")

        val loginActivity = LoginActivity()
        val author = intent.getStringExtra("user")

        val selectedCerbung = Global.cerbungs.find { it.id == cerbungId }
        val paragraph = Global.paragraph

        binding.txtTitlePublic.text = title;
        binding.txtAuthorPublic.text = subHead;
        binding.txtGenrePublic.text = genre;

        val builder = Picasso.Builder(this)
        builder.listener { picasso, uri, exception -> exception.printStackTrace() }
        builder.build().load(imageUrl).into(binding.imgPosterPublic)

        if (selectedCerbung != null) {
            binding.txtTitlePublic.text = selectedCerbung.title
            binding.txtAuthorPublic.text = selectedCerbung.subHead
            binding.txtGenrePublic.text = selectedCerbung.genre

            val builder = Picasso.Builder(this)
            builder.listener { picasso, uri, exception -> exception.printStackTrace() }
            builder.build().load(selectedCerbung.url).into(binding.imgPosterPublic)

            val lm = LinearLayoutManager(this)
            binding.recyclerViewRead.layoutManager = lm

            binding.recyclerViewRead.adapter = ParagraphAdapter(selectedCerbung.id)
        }

        binding.btnSubmitPublic.setOnClickListener {
            val newParagraf = Paragraph(selectedCerbung?.id?:-1, binding.txtAddParagraph.text.toString(), author.toString())

            Log.d(author, "author ")

            paragraph.add(newParagraf)

            Toast.makeText(this, "Paragraf baru berhasil ditambahkan.",Toast.LENGTH_SHORT).show()

            binding.txtAddParagraph.text?.clear()

            val lm = LinearLayoutManager(this)
            binding.recyclerViewRead.layoutManager = lm

            binding.recyclerViewRead.adapter = ParagraphAdapter(selectedCerbung?.id?:-1)
        }
    }
}