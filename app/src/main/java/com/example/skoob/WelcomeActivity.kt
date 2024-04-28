package com.example.skoob

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.skoob.objects.toLoginScreen
import com.example.skoob.objects.toSignupScreen

class WelcomeActivity : AppCompatActivity() {

    private lateinit var buttonSignup: Button
    private lateinit var buttonLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonSignup = findViewById(R.id.welcomeButtonSignUp)
        buttonLogin = findViewById(R.id.welcomeButtonLogIn)

        buttonSignup.setOnClickListener(){



        }

    }


    fun clickSignup() {

        toSignupScreen()

    }

    fun clickLogin() {

        toLoginScreen()

    }

}