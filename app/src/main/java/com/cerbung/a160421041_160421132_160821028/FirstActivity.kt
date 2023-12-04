package com.cerbung.a160421041_160421132_160821028

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    var user = "admin"
    var password = "admin"
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)

            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}