package com.example.kotlinlogin_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Login_Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_registration)

        if (savedInstanceState == null) {
            // Create and set the default fragment
            val defaultFragment = LoginFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_login_reg, defaultFragment)
                .commit()
        }
    }
}