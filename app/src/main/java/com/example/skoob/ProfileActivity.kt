package com.example.skoob

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class ProfileActivity : AppCompatActivity() {

    //profile vars
    private lateinit var bridgeProfileUsername: TextView
    private lateinit var bridgeProfileFavorite1: ImageButton
    private lateinit var bridgeProfileFavorite2: ImageButton
    private lateinit var bridgeProfileFavorite3: ImageButton
    private lateinit var bridgeProfileReturn: ImageButton

    //comments vars
    private lateinit var bridgeProfileUsernameComment: Button
    private lateinit var bridgeProfileIconComment: ImageButton
    private lateinit var bridgeProfileBookReview: ImageButton
    private lateinit var bridgeProfileReviewBook: TextView
    private lateinit var bridgeProfileStar1: ImageView
    private lateinit var bridgeProfileStar2: ImageView
    private lateinit var bridgeProfileStar3: ImageView
    private lateinit var bridgeProfileStar4: ImageView
    private lateinit var bridgeProfileStar5: ImageView

    private lateinit var auth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences
    private val db = Firebase.firestore

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
        bridgeProfileUsernameComment = findViewById(R.id.profileButtonUsernameReview)
        bridgeProfileIconComment = findViewById(R.id.profileButtonIcon)
        bridgeProfileBookReview = findViewById(R.id.profileButtonReviewBook)
        bridgeProfileReviewBook = findViewById(R.id.profileTextReview)
        bridgeProfileStar1 = findViewById(R.id.profileImageStar_1)
        bridgeProfileStar2 = findViewById(R.id.profileImageStar_2)
        bridgeProfileStar3 = findViewById(R.id.profileImageStar_3)
        bridgeProfileStar4 = findViewById(R.id.profileImageStar_4)
        bridgeProfileStar5 = findViewById(R.id.profileImageStar_5)

        auth = Firebase.auth
        sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE)

        fetchUsernameForCurrentUser()

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

        bridgeProfileIconComment.setOnClickListener{

            toProfileScreen()

        }
        bridgeProfileUsernameComment.setOnClickListener{

            toProfileScreen()

        }
        bridgeProfileBookReview.setOnClickListener{

            toBookScreen()

        }


}

    private fun fetchUsernameForCurrentUser() {

        val currentUser = Firebase.auth.currentUser?.uid

        if (currentUser != null) {

                bridgeProfileUsername.text = sharedPreferences.getString("username", null)

        }


    }

    private fun toHomeScreen() {

        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)

    }

    private fun toBookScreen() {

        val intent = Intent(this, BookActivity::class.java)

        intent.putExtra("to", "fromProfile")
        startActivity(intent)

    }

    private fun toProfileScreen() {

        val intentProfile = Intent(this, ProfileActivity::class.java)
        startActivity(intentProfile)

    }
}