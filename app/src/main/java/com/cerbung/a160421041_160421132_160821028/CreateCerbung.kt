package com.cerbung.a160421041_160421132_160821028

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityCreateCerbungBinding

class CreateCerbung : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCerbungBinding
//    var title = ""
//    var description = ""
//    var url = ""
//    var genre = ""
//    var user1 = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCreateCerbungBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*Global.DataHolder.title = txtTitle.text.toString()
        val savedTitle = Global.DataHolder.title
        Global.DataHolder.description = txtDescription.text.toString()
        val savedDescription = Global.DataHolder.description
        Global.DataHolder.url = txtUrl.text.toString()
        val savedUrl = Global.DataHolder.url
        val genreSpinner = findViewById<Spinner>(R.id.genre)*/

        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, Global.genre)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinGenre.adapter = adapter

        binding.btnNextAccess.setOnClickListener {
            val title = binding.txtTitle.text.toString()
            val description = binding.txtDescription.text.toString()
            val url = binding.txtUrl.text.toString()
            val genre = binding.spinGenre.selectedItem.toString()
            val user = intent.getStringExtra("user")

            if (title.isNotEmpty() && description.isNotEmpty() && url.isNotEmpty() && genre.isNotEmpty()) {
                val intent = Intent(this, AccessCerbung::class.java)
                intent.putExtra("title", title)
                intent.putExtra("description", description)
                intent.putExtra("imageUrl", url)
                intent.putExtra("genre", genre)
                intent.putExtra("user", user)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Input tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}