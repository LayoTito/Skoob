package com.example.skoob

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
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


class SignupActivity : AppCompatActivity() {

    private lateinit var bridgeSignupEmail: EditText
    private lateinit var bridgeSignupUsername: EditText
    private lateinit var bridgeSignupPassword: EditText
    private lateinit var bridgeSignupLogin: TextView
    private lateinit var bridgeSignupPolitics: CheckBox
    private lateinit var bridgeSignupCreateAccount: Button
    private lateinit var bridgeSignupCancel: Button

    private lateinit var auth: FirebaseAuth
    private val db = Firebase.firestore

    private var inputSignupEmail: String = ""
    private var inputSignupUsername: String = ""
    private var inputSignupPassword: String = ""

    private val sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = Firebase.auth

        bridgeSignupEmail = findViewById(R.id.signupTextEmail)
        bridgeSignupUsername = findViewById(R.id.signupTextUsername)
        bridgeSignupPassword = findViewById(R.id.signupTextPassword)
        bridgeSignupLogin = findViewById(R.id.signupTextLogin)
        bridgeSignupPolitics = findViewById(R.id.signupCheckBoxPolitics)
        bridgeSignupCreateAccount = findViewById(R.id.signupButtonCreateAccount)
        bridgeSignupCancel = findViewById(R.id.signupButtonCancel)

        bridgeSignupCreateAccount.setOnClickListener {

            if (bridgeSignupPolitics.isChecked) {

                getAccountDataSignUp()

                //if(isValidUsername() && isValidPassword()) {

                    createAccount()

                //}

            } else {

                Toast.makeText(this, "You need to confirm the check box", Toast.LENGTH_SHORT).show()

            }
        }

        bridgeSignupCancel.setOnClickListener {

            toWelcomeScreen()
            finish()

        }

        bridgeSignupLogin.setOnClickListener {

            toLoginScreen()
            finish()

        }
    }

    private fun isValidUsername(): Boolean {

        val hasSpecialCharacter = Regex("[!@#\$ %^&*(),.?\":{}|<>\\s]")

        return !hasSpecialCharacter.containsMatchIn(inputSignupUsername)

    }

    private fun isValidPassword(): Boolean {

        val regex = Regex("[a-zA-Z0-9!@#\$%^&*(),.?\":{}|<>\\s]")

        return inputSignupPassword.length >= 5 && regex.containsMatchIn(inputSignupPassword)

    }

    private fun getAccountDataSignUp() {

        inputSignupEmail = bridgeSignupEmail.text.toString()
        inputSignupUsername = bridgeSignupUsername.text.toString()
        inputSignupPassword = bridgeSignupPassword.text.toString()


    }

    private fun createAccount() {

        auth.createUserWithEmailAndPassword(inputSignupEmail, inputSignupPassword)
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {

                    writeUserData()
                    toHomeScreen()

                } else {

                    Toast.makeText(this, "invalid email", Toast.LENGTH_SHORT).show()


                }

            }
    }

    private fun writeUserData() {

        val currentUser = Firebase.auth.currentUser

        if(currentUser != null) {

            val user = hashMapOf(
                "uid" to currentUser.uid,
                "username" to inputSignupUsername,
                "email" to inputSignupEmail,
                "password" to inputSignupPassword,
                "icon" to null,
                "wallpaper" to null,
            )

            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")

                    writeCookieToken()

                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
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

    private fun toLoginScreen() {

        val intentLogin = Intent(this, LoginActivity::class.java)
        startActivity(intentLogin)
    }

    private fun toWelcomeScreen() {

        val intentWelcome = Intent(this, WelcomeActivity::class.java)
        startActivity(intentWelcome)

    }

    private fun toHomeScreen() {

        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)
    }

}