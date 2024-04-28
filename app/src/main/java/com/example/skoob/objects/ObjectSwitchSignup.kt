package com.example.skoob.objects

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.skoob.SignupActivity

fun toSignupScreen() {

    val intentSignup = Intent(this, SignupActivity::class.java)
    startActivity(intentSignup)

}