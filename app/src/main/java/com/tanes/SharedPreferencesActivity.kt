package com.tanes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.ComponentActivity
import java.lang.Exception

class SharedPreferencesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        val backButton = findViewById<Button>(R.id.back_button)
        val saveButton = findViewById<Button>(R.id.save_button)
        val showButton = findViewById<Button>(R.id.show_button)
        val inputName = findViewById<EditText>(R.id.input_name)
        val listPronouns = findViewById<Spinner>(R.id.list_pronouns)

        backButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

        saveButton.setOnClickListener{
            val userDataSharedPreferences = this.getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val userDataEditor = userDataSharedPreferences.edit()
            val name = inputName.editableText.toString()
            val pronoun = listPronouns.selectedItem.toString()

            userDataEditor.putString("name", name)
            userDataEditor.putString("pronoun", pronoun)
            userDataEditor.apply()

            saveDataInFile(name, pronoun)
        }

        showButton.setOnClickListener{
            val intent = Intent(this, UserDataActivity::class.java)

            startActivity(intent)
        }
    }

    private fun saveDataInFile(name: String, pronoun: String){
        try{
            val fileOutput = openFileOutput("user_data", Context.MODE_PRIVATE)

            fileOutput.write("$name,$pronoun".toByteArray())
            fileOutput.close()
        } catch(error: Exception){
            Log.i("onSaveDataInFile", error.toString())
        }
    }
}
