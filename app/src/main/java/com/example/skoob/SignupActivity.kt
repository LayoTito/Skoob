package com.example.skoob

import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.skoob.objects.toLoginScreen
import com.example.skoob.objects.toWelcomeScreen

class SignupActivity : AppCompatActivity() {

    private lateinit var bridgeEmail: TextView
    private lateinit var bridgeUsername: TextView
    private lateinit var bridgePassword: TextView
    private lateinit var bridgePolitics: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bridgeEmail = findViewById(R.id.signupTextEmail)
        bridgeUsername = findViewById(R.id.signupTextUsername)
        bridgePassword = findViewById(R.id.signupTextPassword)
        bridgePolitics = findViewById(R.id.signupCheckBoxPolitics)

    }

    fun clickCreateAccont() {

        if (bridgePolitics.isChecked){

            toLoginScreen()
            getAccontData()

        } else {

            Toast.makeText(this, "Para a criação de contas, é necessario aceitar os termos de uso", Toast.LENGTH_LONG).show()

        }

    }

    fun clickCancel() {

        toWelcomeScreen()

    }

    fun getAccontData() {



    }


}