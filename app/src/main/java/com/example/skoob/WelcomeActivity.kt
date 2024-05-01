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

    //criação das pontes entre o back e o front-end
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

        //associação das variáveis com os elementos do front-end
        bridgeWelcomeSignup = findViewById(R.id.welcomeButtonSignUp)
        bridgeWelcomeLogin = findViewById(R.id.welcomeButtonLogIn)

        //associando o que acontecerá ao clicar
        bridgeWelcomeSignup.setOnClickListener {

            toSignupScreen()
            finish()

        }

        bridgeWelcomeLogin.setOnClickListener {

            toLoginScreen()
            finish()

        }
    }

    //criação das funções que irão para outras telas
    private fun toLoginScreen() {

        val intentLogin = Intent(this, LoginActivity::class.java)
        startActivity(intentLogin)
    }

    private fun toSignupScreen() {

        val intentSignup = Intent(this, SignupActivity::class.java)
        startActivity(intentSignup)

    }

}