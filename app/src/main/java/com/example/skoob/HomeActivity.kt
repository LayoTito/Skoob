package com.example.skoob

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {

    private lateinit var bridgeHomeProfileIcon: ImageView
    private lateinit var bridgeHomeBook1: ImageView
    private lateinit var bridgeHomeBook2: ImageView
    private lateinit var bridgeHomeBook3: ImageView
    private lateinit var bridgeHomeBook4: ImageView
    private lateinit var bridgeHomeBook5: ImageView
    private lateinit var bridgeHomeBook6: ImageView
    private lateinit var bridgeHomeBook7: ImageView
    private lateinit var bridgeHomeBook8: ImageView
    private lateinit var bridgeHomeBook9: ImageView
    private lateinit var bridgeHomeBook10: ImageView
    private lateinit var bridgeHomeBook11: ImageView
    private lateinit var bridgeHomeBook12: ImageView
    private lateinit var bridgeHomeBook13: ImageView
    private lateinit var bridgeHomeIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bridgeHomeProfileIcon = findViewById(R.id.homeImageProfilePic)
        bridgeHomeBook1 = findViewById(R.id.homeButtonTopRated1)
        bridgeHomeBook2 = findViewById(R.id.homeButtonTopRated2)
        bridgeHomeBook3 = findViewById(R.id.homeButtonTopRated3)
        bridgeHomeBook4 = findViewById(R.id.homeButtonTop10_1)
        bridgeHomeBook5 = findViewById(R.id.homeButtonTop10_2)
        bridgeHomeBook6 = findViewById(R.id.homeButtonTop10_3)
        bridgeHomeBook7 = findViewById(R.id.homeButtonTop10_4)
        bridgeHomeBook8 = findViewById(R.id.homeButtonTop10_5)
        bridgeHomeBook9 = findViewById(R.id.homeButtonTop10_6)
        bridgeHomeBook10 = findViewById(R.id.homeButtonTop10_7)
        bridgeHomeBook11 = findViewById(R.id.homeButtonTop10_8)
        bridgeHomeBook12 = findViewById(R.id.homeButtonTop10_9)
        bridgeHomeBook13 = findViewById(R.id.homeButtonTop10_10)
        bridgeHomeIcon = findViewById(R.id.homeButtonLongIcon)

        bridgeHomeProfileIcon.setOnClickListener {

            toProfileScreen()

        }

        bridgeHomeBook1.setOnClickListener {

            toBookScreen()

        }

        bridgeHomeBook2.setOnClickListener {

            toBookScreen()

        }

        bridgeHomeBook3.setOnClickListener {

            toBookScreen()

        }

        bridgeHomeBook4.setOnClickListener {

            toBookScreen()

        }

        bridgeHomeBook5.setOnClickListener {

            toBookScreen()

        }

        bridgeHomeBook6.setOnClickListener {

            toBookScreen()

        }

        bridgeHomeBook7.setOnClickListener {

            toBookScreen()

        }

        bridgeHomeBook8.setOnClickListener {

            toBookScreen()

        }

        bridgeHomeBook9.setOnClickListener {

            toBookScreen()

        }

        bridgeHomeBook10.setOnClickListener {

            toBookScreen()

        }

        bridgeHomeBook11.setOnClickListener {

            toBookScreen()

        }

        bridgeHomeBook12.setOnClickListener {

            toBookScreen()

        }

        bridgeHomeBook13.setOnClickListener {

            toBookScreen()

        }


        bridgeHomeIcon.setOnClickListener {

            toHomeScreen()
            finish()

        }


    }

    private fun toHomeScreen() {

        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)

    }

    private fun toBookScreen() {

        val intent = Intent(this, BookActivity::class.java)

        intent.putExtra("to", "fromHome")
        startActivity(intent)

    }

    private fun toProfileScreen() {

        val intentProfile = Intent(this, ProfileActivity::class.java)
        startActivity(intentProfile)

    }
}