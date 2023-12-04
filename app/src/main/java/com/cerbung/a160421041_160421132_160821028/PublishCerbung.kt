package com.cerbung.a160421041_160421132_160821028

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityAccessCerbungBinding
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityPublicReadBinding
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityPublishCerbungBinding
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityRestrictedReadBinding

class PublishCerbung : AppCompatActivity() {
    private lateinit var binding: ActivityPublishCerbungBinding
    var access: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublishCerbungBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val paragraph = intent.getStringExtra("paragraph")
        val user = intent.getStringExtra("user")
        val access = intent.getStringExtra("access")
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val url = intent.getStringExtra("imageUrl")
        val genre = intent.getStringExtra("genre")

        val cerbungs = Global.cerbungs
        val paragraphs = Global.paragraph

        binding.txtTitlePublish.text = title.toString()
        binding.txtDescriptionPublish.text = description.toString()
        binding.txtGenre.text = genre.toString()
        binding.txtParagraphPublish.text = paragraph.toString()
        binding.btnPublish.isEnabled = false

        if (access == "Restricted")
        {
            binding.txtAccessPublish.text = "Restricted"
        } else if (access == "Public")
        {
            binding.txtAccessPublish.text = "Public"
        }

        binding.checkBoxRules.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.btnPublish.isEnabled = isChecked
        }


        binding.btnPublish.setOnClickListener {
            val newCerbung = Cerbung(Global.id, title.toString(),user.toString(),description.toString(),url.toString(),genre.toString(),access.toString())

            cerbungs.add(newCerbung)

            val newParagraf = Paragraph(Global.id, paragraph.toString(), user.toString())

            paragraphs.add(newParagraf)

            Toast.makeText(this, "Cerita berhasil ditambahkan", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("user",user)
            startActivity(intent)

            Global.id++
        }

        binding.btnPrevAccess.setOnClickListener {
            val intent = Intent(this, AccessCerbung::class.java)
            intent.putExtra("title",title)
            intent.putExtra("description",description)
            intent.putExtra("imageUrl",url)
            intent.putExtra("genre",genre)
            intent.putExtra("user",user)
            startActivity(intent)
        }
    }
}