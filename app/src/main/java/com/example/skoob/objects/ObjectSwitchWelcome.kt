package com.example.skoob.objects

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.skoob.WelcomeActivity

fun toWelcomeScreen() {

    val intentWelcome = Intent(this, WelcomeActivity::class.java)
    startActivity(intentWelcome)

}