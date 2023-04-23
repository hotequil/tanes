package com.tanes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Life cycle", "onCreate")

        val setTextButton = findViewById<Button>(R.id.set_text_button)
        val openWebsiteButton = findViewById<Button>(R.id.open_website)
        val nextActivityButton = findViewById<Button>(R.id.next_activity)
        val constraintActivityButton = findViewById<Button>(R.id.constraint_activity)
        val tableActivityButton = findViewById<Button>(R.id.table_activity)
        val typeText = findViewById<EditText>(R.id.type_text)
        val resultText = findViewById<TextView>(R.id.result_text)

        setTextButton.setOnClickListener{
            val text = typeText.editableText.toString()

            resultText.text = text
        }

        openWebsiteButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://hotequil.tech"))

            startActivity(intent)
        }

        nextActivityButton.setOnClickListener{
            val intent = Intent(this, NextActivity::class.java)

            startActivity(intent)
        }

        constraintActivityButton.setOnClickListener{
            val intent = Intent(this, ConstraintActivity::class.java)

            startActivity(intent)
        }

        tableActivityButton.setOnClickListener{
            val intent = Intent(this, TableActivity::class.java)

            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("Life cycle", "onStart")
    }

    override fun onResume(){
        super.onResume()

        Log.i("Life cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("Life cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("Life cycle", "onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("Life cycle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("Life cycle", "onDestroy")
    }

    fun setText(view: View){
        Log.i("View", view.toString())
        Toast.makeText(this, "It was clicked", Toast.LENGTH_SHORT).show()
    }
}
