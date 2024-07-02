package com.example.skoob

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var bridgeLoginUsername: EditText
    private lateinit var bridgeLoginPassword: EditText
    private lateinit var bridgeLoginTextSignup: TextView
    private lateinit var bridgeLoginLogin: Button
    private lateinit var bridgeLoginCancel: Button

    private val db = Firebase.firestore

    private lateinit var auth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

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

        auth = Firebase.auth
        sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        bridgeLoginUsername = findViewById(R.id.loginTextUsername)
        bridgeLoginPassword = findViewById(R.id.loginTextPassword)
        bridgeLoginTextSignup = findViewById(R.id.loginTextSignup)
        bridgeLoginLogin = findViewById(R.id.loginButtonLogin)
        bridgeLoginCancel = findViewById(R.id.loginButtonCancel)

        bridgeLoginLogin.setOnClickListener {

            getAccountDataLogIn()
            logIn()
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

        inputLoginEmail = bridgeLoginUsername.text.toString()
        inputLoginPassword = bridgeLoginPassword.text.toString()

    }

    private fun logIn() {

        auth.signInWithEmailAndPassword(inputLoginEmail, inputLoginPassword)
            .addOnCompleteListener(this) {task ->

                if(task.isSuccessful) {

                    writeCookieToken()
                    //writeCookieUsername()

                    toHomeScreen()

                } else {

                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

                }
            }
    }

    private fun writeCookieToken() {

        val firebaseUser = FirebaseAuth.getInstance().currentUser
        firebaseUser?.getIdToken(true)?.addOnCompleteListener { task ->

            if (task.isSuccessful) {

                val idToken = task.result?.token

                editor.putString("userToken", idToken)
                editor.apply()

            }
        }
    }

    private fun writeCookieUsername() {

        val userId = auth.currentUser?.uid
        db.collection("users").document(userId.toString()).get().addOnSuccessListener { document ->
            val name = document.getString("username")

            editor.putString("username", name)
            editor.apply()
        }
    }

    private fun toHomeScreen() {

        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)
    }

    private fun toSignupScreen() {

        val intentSignup = Intent(this, SignupActivity::class.java)
        startActivity(intentSignup)

    }

    private fun toWelcomeScreen() {

        val intentWelcome = Intent(this, WelcomeActivity::class.java)
        startActivity(intentWelcome)

    }
}