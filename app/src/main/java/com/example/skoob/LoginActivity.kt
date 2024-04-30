package com.example.skoob

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.skoob.objects.toHomeScreen
import com.example.skoob.objects.toSignupScreen
import com.example.skoob.objects.toWelcomeScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var bridgeLoginUsername: EditText
    private lateinit var bridgeLoginPassword: EditText
    private lateinit var bridgeLoginTextSignup: EditText
    private lateinit var bridgeLoginLogin: Button
    private lateinit var bridgeLoginCancel: Button

    private lateinit var auth: FirebaseAuth

    private var inputLoginEmail: String = ""
    private var inputLoginPassword: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bridgeLoginUsername = findViewById(R.id.loginTextUsername)
        bridgeLoginPassword = findViewById(R.id.loginTextPassword)
        bridgeLoginTextSignup = findViewById(R.id.loginTextSignup)
        bridgeLoginLogin = findViewById(R.id.loginButtonLogin)
        bridgeLoginCancel = findViewById(R.id.loginButtonCancel)

        auth = Firebase.auth

        bridgeLoginLogin.setOnClickListener {

            getAccountDataLogIn()
            logIn()
            finish()
            toHomeScreen()

        }

        bridgeLoginCancel.setOnClickListener {

            toWelcomeScreen()
            finish()

        }

        bridgeLoginTextSignup.setOnClickListener {

            toSignupScreen()
            finish()

        }

    }

    private fun getAccountDataLogIn() {

        inputLoginEmail = bridgeLoginUsername.toString()
        inputLoginPassword = bridgeLoginPassword.toString()

    }

    private fun logIn() {

        auth.signInWithEmailAndPassword(inputLoginEmail, inputLoginPassword)
            .addOnCompleteListener(this) {task ->

                if(task.isSuccessful) {

                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()

                    toHomeScreen()

                } else {

                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

                }
            }
    }
}