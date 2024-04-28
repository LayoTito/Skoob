package com.example.skoob

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var bridgeSignupUsername: TextView
    private lateinit var bridgeSignupPassword: TextView
    private lateinit var bridgeSignupLogin: TextView
    private lateinit var bridgeSignupPolitics: CheckBox
    private lateinit var bridgeSignupLogin: Button
    private lateinit var bridgeSignupCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bridgeSignupUsername = findViewById(R.id.loginTextUsername)
        bridgeSignupPassword = findViewById(R.id.loginTextPassword)
        bridgeSignupLogin = findViewById(R.id.signupTextLogin)
        bridgeSignupPolitics = findViewById(R.id.loginCheckBoxPolitics)
        bridgeSignupLogin = findViewById(R.id.loginButtonLogin)
        bridgeSignupCancel = findViewById(R.id.signupButtonCancel)

    }
}