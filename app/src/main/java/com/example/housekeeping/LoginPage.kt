package com.example.housekeeping

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        var loginBT = findViewById<Button>(R.id.loginBT) as Button
        var nameET = findViewById<EditText>(R.id.userNameET) as EditText

        loginBT.setOnClickListener{
            val message: String = nameET.text.toString()
            val intent = Intent(this, HomePage::class.java)
            intent.putExtra("key", message)
            startActivity(intent)


        }
    }
}