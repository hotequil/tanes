package com.tanes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.security.crypto.EncryptedSharedPreferences
import java.lang.Exception
import java.nio.charset.Charset
import java.util.StringTokenizer

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
        val showEncryptedUserDataButton = findViewById<Button>(R.id.show_encrypted_user_data_button)

        val userDataEncryptedSharedPreferences = EncryptedSharedPreferences.create(
            "encrypted_user_data",
            "app-key-here",
            this,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        if(name !== "") textName.text = name
        if(pronoun !== "") textPronoun.text = pronoun

        val userData = showDataInFile()

        if(userData !== "") {
            val tokenizer = StringTokenizer(userData, ",")
            val tokenizerName = if(tokenizer.hasMoreTokens()) tokenizer.nextToken() else ""
            val tokenizerPronoun = if(tokenizer.hasMoreTokens()) tokenizer.nextToken() else ""

            if(tokenizerName !== "" && tokenizerPronoun !== "")
                Toast.makeText(this, "$tokenizerPronoun is pronoun of $tokenizerName", Toast.LENGTH_LONG).show()
        }

        backButton.setOnClickListener{
            val intent = Intent(this, SharedPreferencesActivity::class.java)

            startActivity(intent)
        }

        showEncryptedUserDataButton.setOnClickListener{
            val decryptedName = userDataEncryptedSharedPreferences.getString("name", "")
            val decryptedPronoun = userDataEncryptedSharedPreferences.getString("pronoun", "")

            if(decryptedName !== "" && decryptedPronoun !== "")
                Toast.makeText(this, "$decryptedName is pronoun of $decryptedPronoun", Toast.LENGTH_LONG).show()
        }
    }

    private fun showDataInFile(): String{
        return try{
            val fileInput = openFileInput("user_data")
            val bytes = fileInput.readBytes()

            fileInput.close()

            bytes.toString(Charset.defaultCharset())
        } catch(error: Exception){
            Log.i("onShowDataInFile", error.toString())

            ""
        }
    }
}
