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

        fetchUsernameForCurrentUser(OnCompleteListener { task ->
            if (task.isSuccessful) {
                val documentSnapshot = task.result
                if (documentSnapshot != null && documentSnapshot.exists()) {
                    val username = documentSnapshot.getString("username")
                    if (username != null) {
                        println("Username: $username")

                        bridgeProfileUsername.text = username
                    }
                }
            }
        })

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

    private fun fetchUsernameForCurrentUser(onCompleteListener: OnCompleteListener<DocumentSnapshot>) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserId: String? = currentUser?.uid

        val documentRef = db.collection("users").document(currentUserId.toString())

        documentRef.get()
            .addOnCompleteListener(onCompleteListener)
    }


    private fun toHomeScreen() {

        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)

    }

    private fun toBookScreen() {

        val intentBook = Intent(this, BookActivity::class.java)
        startActivity(intentBook)
    }
    private fun toProfileScreen() {

        val intentProfile = Intent(this, ProfileActivity::class.java)
        startActivity(intentProfile)

    }
}