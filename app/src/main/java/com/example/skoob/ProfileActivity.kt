package com.example.skoob

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class ProfileActivity : AppCompatActivity() {

    //profile vars
    private lateinit var bridgeProfileUsername: Text
    private lateinit var bridgeProfileFavorite1: ImageButton
    private lateinit var bridgeProfileFavorite2: ImageButton
    private lateinit var bridgeProfileFavorite3: ImageButton
    private lateinit var bridgeProfileReturn: ImageButton

    //comments vars
    private lateinit var bridgeProfileUsernameComment: Text
    private lateinit var bridgeProfileBookReview: Text
    private lateinit var bridgeProfileReviewBook: ImageView
    private lateinit var bridgeProfileStar1: ImageView
    private lateinit var bridgeProfileStar2: ImageView
    private lateinit var bridgeProfileStar3: ImageView
    private lateinit var bridgeProfileStar4: ImageView
    private lateinit var bridgeProfileStar5: ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bridgeProfileUsername = findViewById(R.id.profileTextUsername)
        bridgeProfileFavorite1 = findViewById(R.id.profileButtonFavoriteBook1)
        bridgeProfileFavorite2 = findViewById(R.id.profileButtonFavoriteBook2)
        bridgeProfileFavorite3 = findViewById(R.id.profileButtonFavoriteBook3)
        bridgeProfileReturn = findViewById(R.id.profileButtonReturn)


        bridgeProfileBookReview = findViewById(R.id.profileImageReviewBook)
        bridgeProfileReviewBook = findViewById(R.id.profileTextReview)
        bridgeProfileStar1 = findViewById(R.id.profileImageStar_1)
        bridgeProfileStar2 = findViewById(R.id.profileImageStar_2)
        bridgeProfileStar3 = findViewById(R.id.profileImageStar_3)
        bridgeProfileStar4 = findViewById(R.id.profileImageStar_4)
        bridgeProfileStar5 = findViewById(R.id.profileImageStar_5)



        bridgeProfileFavorite1.setOnClickListener {

            toBookScreen()

        }


        bridgeProfileFavorite2.setOnClickListener {

            toBookScreen()

        }


        bridgeProfileFavorite3.setOnClickListener {

            toBookScreen()

        }


        bridgeProfileReturn.setOnClickListener {

            toHomeScreen()

        }


}
    private fun toHomeScreen() {

        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)

    }

    private fun toBookScreen() {

        val intentBook = Intent(this, BookActivity::class.java)
        startActivity(intentBook)
    }
}