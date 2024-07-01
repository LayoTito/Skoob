package com.example.skoob

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BookActivity : AppCompatActivity() {

    private lateinit var bridgeBookAdd: ImageButton
    private lateinit var bridgeBookReviewIcon: ImageView
    private lateinit var bridgeBookReviewUsername: TextView
    private lateinit var bridgeBookButtonReturn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bridgeBookAdd = findViewById(R.id.bookButtonAdd)
        bridgeBookReviewIcon = findViewById(R.id.bookImageIcon)
        bridgeBookReviewUsername = findViewById(R.id.bookTextUsernameReview)
        bridgeBookButtonReturn = findViewById(R.id.bookButtonReturn)

        bridgeBookAdd.setOnClickListener {

            toReviewScreen()

        }

        bridgeBookReviewIcon.setOnClickListener {

            toProfileScreen()

        }

        bridgeBookReviewUsername.setOnClickListener {

            toProfileScreen()

        }

        bridgeBookButtonReturn.setOnClickListener{

            toAnotherScreen()

        }


    }

    private fun toProfileScreen() {

        val intentProfile = Intent(this, ProfileActivity::class.java)
        startActivity(intentProfile)

    }

    private fun toReviewScreen() {

        val intentReview = Intent(this, ReviewActivity::class.java)
        startActivity(intentReview)
    }

    private fun toAnotherScreen() {

        val data: Bundle? = intent.extras
        val path = data?.getString("to")

        if (path == "fromHome") {

            toHomeScreen()
        }

        if (path == "fromProfile") {

            val intentProfile = Intent(this, ProfileActivity::class.java)
            startActivity(intentProfile)
        }

    }

    private fun toHomeScreen() {

        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)
    }
}