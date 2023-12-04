package com.cerbung.a160421041_160421132_160821028

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityLoginBinding
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityRegisterBinding

class LoginActivity : AppCompatActivity() {
    var user = ""
    var username1 = "admin"
    var password1 = "admin"
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val users = Global.users

        binding.btnLogin.setOnClickListener{
            val username = binding.txtUsername.text.toString()
            val password = binding.txtPassword.text.toString()

            var userFound = false

            for (user in users) {
                if (user.username == username && user.password == password) {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("user", username)
                    startActivity(intent)
                    Toast.makeText(this, "Welcome, $username", Toast.LENGTH_SHORT).show()
                    userFound = true
                    finishAffinity()
                    break
                }
            }
            if (!userFound) { //sama dengan userFound tetap bernilai false
                showErrorMessage()
            }


        }
    }
    private fun showErrorMessage() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Error")
        alertDialogBuilder.setMessage("Invalid username or password")
        alertDialogBuilder.setPositiveButton("OK") { dialog, which ->
            dialog.dismiss()
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}