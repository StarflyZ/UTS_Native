package com.cerbung.a160421041_160421132_160821028

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.RadioButton
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityAccessCerbungBinding
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityCreateCerbungBinding

class AccessCerbung : AppCompatActivity() {
    private lateinit var binding: ActivityAccessCerbungBinding
    var selectedAccess = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccessCerbungBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.groupAccess.setOnCheckedChangeListener { radioGroup, id ->
            /*val selectedRadio = findViewById<RadioButton>(id)
            selectedRadio.setTextColor(Color.RED)*/

            val radio = findViewById<RadioButton>(binding.groupAccess.checkedRadioButtonId)
            val tag = radio.tag.toString()
            Log.d("radiorating", tag)
            selectedAccess = radio.text.toString()
        }

        binding.btnNextPublish.setOnClickListener {
            val paragraph = binding.txtParagraphCreate.text.toString()
            val user = intent.getStringExtra("user")
            val title = intent.getStringExtra("title")
            val description = intent.getStringExtra("description")
            val url = intent.getStringExtra("imageUrl")
            val genre = intent.getStringExtra("genre")

            val intent = Intent(this, PublishCerbung::class.java)
            intent.putExtra("title",title)
            intent.putExtra("description",description)
            intent.putExtra("imageUrl",url)
            intent.putExtra("genre",genre)
            intent.putExtra("paragraph", paragraph)
            intent.putExtra("user", user)
            intent.putExtra("access", selectedAccess)

            startActivity(intent)
        }

        binding.btnPrevCreate.setOnClickListener {
            val user = intent.getStringExtra("user")
            val intent = Intent(this, CreateCerbung::class.java)
            intent.putExtra("user",user)
            startActivity(intent)
        }
    }
}