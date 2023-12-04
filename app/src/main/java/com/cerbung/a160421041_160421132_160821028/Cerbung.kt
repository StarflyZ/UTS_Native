package com.cerbung.a160421041_160421132_160821028

//data class Paragraph(val text: String, val author: String)

data class Paragraph(val id: Int, val text: String, val author: String)

data class Cerbung(
    val id: Int,
    val title:String,
    val subHead:String,
    val desc:String,
    val url:String,
    val genre: String,
    val access: String
)

data class User(val username: String, val password: String)
