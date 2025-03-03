package com.alan_neculpan_20250303

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    private lateinit var nameEditText: EditText
    private lateinit var welcomeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sessionManager = SessionManager(this)
        nameEditText = findViewById(R.id.nameEditText)
        welcomeTextView = findViewById(R.id.welcomeTextView)

        val savedName = sessionManager.getUserName()
        if (savedName != null) {
            welcomeTextView.text = "Bienvenido: $savedName"
        }

        findViewById<Button>(R.id.loginButton).setOnClickListener {
            val name = nameEditText.text.toString()
            if (name.isNotEmpty()) {
                sessionManager.saveUserName(name)
                welcomeTextView.text = "Bienvenido: $name"
                startActivity(Intent(this, FarmaciaListActivity::class.java))
            }
        }
    }
}