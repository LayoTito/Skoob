package com.example.skoob

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewActivity : AppCompatActivity() {

    private lateinit var bridgeReviewReturn: ImageButton
    private lateinit var bridgeReviewComment: EditText
    private lateinit var bridgeReviewRate1: Button
    private lateinit var bridgeReviewRate2: Button
    private lateinit var bridgeReviewRate3: Button
    private lateinit var bridgeReviewRate4: Button
    private lateinit var bridgeReviewRate5: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bridgeReviewReturn = findViewById(R.id.reviewButtonReturn)
        bridgeReviewComment = findViewById(R.id.reviewEditReview)
        bridgeReviewRate1 = findViewById(R.id.reviewButtonRate_1)
        bridgeReviewRate2 = findViewById(R.id.reviewButtonRate_2)
        bridgeReviewRate3 = findViewById(R.id.reviewButtonRate_3)
        bridgeReviewRate4 = findViewById(R.id.reviewButtonRate_4)
        bridgeReviewRate5 = findViewById(R.id.reviewButtonRate_5)


        bridgeReviewReturn.setOnClickListener{

            toHomeScreen()

        }
    }
    private fun toHomeScreen() {

        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)

    }
}