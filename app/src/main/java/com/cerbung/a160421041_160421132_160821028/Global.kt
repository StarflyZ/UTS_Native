package com.cerbung.a160421041_160421132_160821028

object Global {
    var id = 4
    var cerbungNumber = 1
    var darkMode = false
    var notification = false
    val cerbungs =
        arrayListOf(
            Cerbung(
                1,
                "Rahasia Terkunci di Perpustakaan Kuno",
                "NebulaNomad",
                "Rahasia Terkunci di Perpustakaan Kuno mengisahkan tentang seorang mahasiswa bernama Alex yang secara tak sengaja menemukan sebuah buku kuno yang misterius di perpustakaan universitasnya.",
                "https://media.suara.com/pictures/970x544/2021/02/26/64331-perpustakaan-pixabaycom.jpg",
                "Misteri",
                "Public"
            ),
            Cerbung(
                2,
                "Dunia Dalam Cermin: Kisah Terbalik yang Misterius",
                "by NebulaNomad",
                "Dengan hati berdebar, Alex mengelilingi toko antik tua itu. Matanya tertarik pada cermin kuno yang memancarkan keindahan misterius. Tanpa pikir panjang, ia menyentuh permukaannya, dan dunia seketika terbalik ",
                "https://sportshub.cbsistatic.com/i/2021/03/17/736c8ac7-29f2-4003-83f0-b6882a423790/avengers-infinity-war-1183475.jpg",
                "Misteri",
                "Public"
            ),
            Cerbung(
                3,
                "Teka-teki Kehilangan Permata Maharaja",
                "by SolsticeDreamer",
                "Dalam sekejap, Alex merasa seperti melayang dalam ruang waktu yang tak terbatas, dan sekarang, di hadapannya terbentang dunia yang ajaib dan tak dikenal.\nSolsticeDreamer",
                "https://external-preview.redd.it/p-agWomS3q2ZG6W1y98m-2wFO29Z8j5B_ay4DVKf1OI.jpg?auto=webp&s=2678cf2a482fcfac559e4e6f577374fdd1fca5c3",
                "Petualangan",
                "Restricted"
            )
        )
    val paragraph =
        arrayListOf(Paragraph(1, "Seorang pemuda bernama Andi menemukan perpustakaan kuno itu secara tidak sengaja. Dia penasaran dengan perpustakaan itu dan memutuskan untuk menyelidikinya."
            , "Penulis 1"),
                    Paragraph(1, "Andi menemukan bahwa perpustakaan itu penuh dengan buku-buku kuno dan artefak misterius. Dia mulai mempelajari rahasia perpustakaan itu dan menyadari bahwa rahasia itu lebih berbahaya dari yang dia bayangkan.",
                        "Penulis 2"),
                    Paragraph(2, "Di sebuah kota kecil yang tenang, hiduplah seorang gadis bernama Arina. Arina adalah gadis yang cerdas dan selalu penasaran dengan dunia di sekitarnya. Suatu hari, Arina melihat sebuah cermin tua di rumah neneknya. Cermin itu sangat indah, dengan bingkai kayu yang diukir dengan rumit.",
                        "Penulis 3"),
                    Paragraph(3, "Pada zaman dahulu, di sebuah kerajaan yang makmur, hiduplah seorang maharaja yang bijaksana dan adil. Maharaja itu memiliki sebuah permata yang sangat berharga, yang disebut Permata Maharaja. Permata itu terbuat dari berlian yang sangat indah dan berkilau.",
                        "Penulis 4"),
                    Paragraph(2, "Arina mulai memperhatikan cermin itu setiap hari. Dia merasa ada sesuatu yang aneh dengan cermin itu. Cermin itu seolah-olah memiliki kekuatan magis. Suatu malam, Arina melihat bayangan yang bergerak di dalam cermin itu.",
                        "Penulis 5")
        )

    val genre = arrayOf(
        Genre(1, "Action"),
        Genre(2, "Anime"),
        Genre(3, "Comedy"),
        Genre(4, "Crime"),
        Genre(5, "Drama"),
        Genre(6, "History"),
        Genre(7, "Horror"),
        Genre(8, "Kids"),
        Genre(9, "Romance"),
        Genre(10, "Sci-Fi & Fantasy"),
        Genre(11, "Thriller")
    )

    val users =
        arrayListOf(User("timotius", "123"),
                    User("steven", "123"),
                    User("jason", "123")
        )

}