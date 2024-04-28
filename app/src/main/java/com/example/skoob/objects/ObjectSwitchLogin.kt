package com.example.skoob.objects

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.skoob.LoginActivity

fun toLoginScreen() {

    val intentLogin = Intent(this, LoginActivity::class.java)
    startActivity(intentLogin)
}