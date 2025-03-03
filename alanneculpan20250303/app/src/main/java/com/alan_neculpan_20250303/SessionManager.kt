package com.alan_neculpan_20250303

import android.content.Context
import android.content.SharedPreferences

class SessionManager (context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveUserName(name: String) {
        sharedPreferences.edit().putString("user_name", name).apply()
    }

    fun getUserName(): String? {
        return sharedPreferences.getString("user_name", null)
    }

    fun isUserLoggedIn(): Boolean {
        return getUserName() != null
    }

    fun logout() {
        sharedPreferences.edit().remove("user_name").apply()
    }

}