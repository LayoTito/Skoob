package com.example.skoob

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {

    private lateinit var bridgeWelcomeSignup: Button
    private lateinit var bridgeWelcomeLogin: Button
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

        bridgeWelcomeSignup.setOnClickListener {

            toSignupScreen()
            finish()

        }

        bridgeWelcomeLogin.setOnClickListener {

            toLoginScreen()
            finish()

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

}