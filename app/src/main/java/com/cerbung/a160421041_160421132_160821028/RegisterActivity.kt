package com.cerbung.a160421041_160421132_160821028

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.cerbung.a160421041_160421132_160821028.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    companion object {
        val USERNAME = "NAME"
        val PASSWORD = "PASS"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val users = Global.users

        binding.btnRegister.setOnClickListener{
            val intent = Intent(this, FirstActivity::class.java)

            val newUser = User(binding.txtUsername.text.toString(), binding.txtPassword.text.toString())

            users.add(newUser)

            if(binding.txtPassword.text.toString() == binding.txtPassword3.text.toString()){
                Toast.makeText(this, "Akun berhasil dibuat.", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }else{
                showErrorMessage()
            }
        }
    }
    private fun showErrorMessage() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Error")
        alertDialogBuilder.setMessage("password tidak sama!")
        alertDialogBuilder.setPositiveButton("OK") { dialog, which ->
            dialog.dismiss()
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}