package com.example.skoob

import DatabaseHelper
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.skoob.objects.toLoginScreen
import com.example.skoob.objects.toWelcomeScreen

class SignupActivity : AppCompatActivity() {

    private lateinit var bridgeSignupEmail: EditText
    private lateinit var bridgeSignupUsername: EditText
    private lateinit var bridgeSignupPassword: EditText
    private lateinit var bridgeSignupLogin: EditText
    private lateinit var bridgeSignupPolitics: CheckBox
    private lateinit var bridgeSignupCreateAccont: Button
    private lateinit var bridgeSignupCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bridgeSignupEmail = findViewById(R.id.signupTextEmail)
        bridgeSignupUsername = findViewById(R.id.signupTextEmail)
        bridgeSignupPassword = findViewById(R.id.signupTextPassword)
        bridgeSignupLogin = findViewById(R.id.signupTextLogin)
        bridgeSignupPolitics = findViewById(R.id.signupCheckBoxPolitics)
        bridgeSignupCreateAccont = findViewById(R.id.signupButtonCreateAccount)
        bridgeSignupCancel = findViewById(R.id.signupButtonCancel)

        bridgeSignupCreateAccont.setOnClickListener {

            if (bridgeSignupPolitics.isChecked){

                val data = DatabaseHelper(name = "TABLE_NAME")

                val dbHelper = DatabaseHelper(context)
                val db = dbHelper.writableDatabase

                val value = ContentValues().apply {

                    put("name", data.name)

                }

                val newRowId = db?.insert("mytable", null, values)

                if (newRowId != -1L) {


                }else {

                }

                getAccontData()
                toLoginScreen()

            } else {

                Toast.makeText(this, "Para a criação de contas, é necessario aceitar os termos de uso", Toast.LENGTH_LONG).show()

            }
        }

        bridgeSignupCancel.setOnClickListener {

            finish()

        }

        bridgeSignupLogin.setOnClickListener {

            toLoginScreen()

        }
    }

    fun getAccontData() {



    }
}