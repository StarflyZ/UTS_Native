package com.cerbung.a160421041_160421132_160821028

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getStringExtra("user")

        val lm = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = lm
        binding.recyclerView.adapter = CerbungAdapter(user.toString())

        binding.btnCreate.setOnClickListener {
            val intent = Intent(this, CreateCerbung::class.java)
            intent.putExtra("user",user)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

//    override fun onResume() {
//        super.onResume()
//
//        val user = intent.getStringExtra("user")
//
//        val adapter = CerbungAdapter(user.toString())
//        binding.recyclerView.adapter = adapter
//    }
}