package com.example.skoob

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BookActivity : AppCompatActivity() {

    //criação das pontes entre o back e o front-end
    private lateinit var bridgeBookAdd: ImageButton
    private lateinit var bridgeBookReviewIcon: ImageView
    private lateinit var bridgeBookReviewUsername: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //associação das variáveis com os elementos do front-end
        bridgeBookAdd = findViewById(R.id.bookButtonAdd)
        bridgeBookReviewIcon = findViewById(R.id.bookImageIcon)
        bridgeBookReviewUsername = findViewById(R.id.bookTextUsernameReview)


        //associando o que acontecerá ao clicar
        bridgeBookAdd.setOnClickListener {

            toReviewScreen()

        }

        bridgeBookReviewIcon.setOnClickListener {

            toProfileScreen()

        }

        bridgeBookReviewUsername.setOnClickListener {

            toProfileScreen()

        }




    }

    //criação das funções que irão para outras telas
    private fun toProfileScreen() {

        val intentProfile = Intent(this, ProfileActivity::class.java)
        startActivity(intentProfile)

    }

    private fun toReviewScreen() {

        val intentReview = Intent(this, ReviewActivity::class.java)
        startActivity(intentReview)
    }

    val path = intent.getStringExtra("to")

    private fun ToAnotherScreen() {

        if (path == "fromHome") {

            val intentHome = Intent(this, HomeActivity::class.java)
            startActivity(intentHome)

        }

        if (path == "fromProfile") {

            val intentProfile = Intent(this, ProfileActivity::class.java)
            startActivity(intentProfile)
        }


    }
}