package com.tanes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class UserDataActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)

        val userDataSharedPreferences = this.getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val name = userDataSharedPreferences.getString("name", "")
        val pronoun = userDataSharedPreferences.getString("pronoun", "")
        val textName = findViewById<TextView>(R.id.name)
        val textPronoun = findViewById<TextView>(R.id.pronoun)
        val backButton = findViewById<Button>(R.id.back_button)

        if(name !== "") textName.text = name
        if(pronoun !== "") textPronoun.text = pronoun

        backButton.setOnClickListener{
            val intent = Intent(this, SharedPreferencesActivity::class.java)

            startActivity(intent)
        }
    }
}
