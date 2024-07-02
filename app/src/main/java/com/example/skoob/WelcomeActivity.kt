package com.example.skoob

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class WelcomeActivity : AppCompatActivity() {

    private lateinit var bridgeWelcomeSignup: Button
    private lateinit var bridgeWelcomeLogin: Button

    private lateinit var auth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bridgeWelcomeSignup = findViewById(R.id.welcomeButtonSignUp)
        bridgeWelcomeLogin = findViewById(R.id.welcomeButtonLogIn)

        auth = Firebase.auth
        sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE)

        val userToken = sharedPreferences.getString("userToken", null)

        if (userToken != null) {

            getToken(userToken)

        }

        bridgeWelcomeSignup.setOnClickListener {

            toSignupScreen()
            finish()

        }

        bridgeWelcomeLogin.setOnClickListener {

            toLoginScreen()
            finish()

        }



    }

    private fun getToken(userToken: String) {

        auth.signInWithCustomToken(userToken).addOnCompleteListener(this) { task ->

            if(task.isSuccessful) {

                toHomeScreen()
                finish()

            }

        }

    }

    private fun toLoginScreen() {

        val intentLogin = Intent(this, LoginActivity::class.java)
        startActivity(intentLogin)
    }

    private fun toSignupScreen() {

        val intentSignup = Intent(this, SignupActivity::class.java)
        startActivity(intentSignup)

    }

    private fun toHomeScreen() {

        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)

    }

}