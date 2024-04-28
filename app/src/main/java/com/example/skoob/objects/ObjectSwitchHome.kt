package com.example.skoob.objects

import android.content.Intent
import androidx.core.content.ContextCompat
import com.example.skoob.LoginActivity

fun toHomeScreen() {

    val intentHome = Intent(this, LoginActivity::class.java)
    ContextCompat.startActivity(intentHome)
}