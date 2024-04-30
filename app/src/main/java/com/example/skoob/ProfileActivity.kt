package com.example.skoob

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
    private lateinit var bridgeUsername: Text
    private lateinit var bridgeFavorite1: ImageButton
    private lateinit var bridgeFavorite2: ImageButton
    private lateinit var bridgeFavorite3: ImageButton

    //comments vars
    private lateinit var bridgeUsernameComment: Text
    private lateinit var bridgeBookReview: Text
    private lateinit var bridgeReviewBook: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bridgeUsername = findViewById(R.id.profileTextUsername)
        bridgeFavorite1 = findViewById(R.id.profileButtonFavoriteBook1)
        bridgeFavorite2 = findViewById(R.id.profileButtonFavoriteBook2)
        bridgeFavorite3 = findViewById(R.id.profileButtonFavoriteBook3)



    }
}