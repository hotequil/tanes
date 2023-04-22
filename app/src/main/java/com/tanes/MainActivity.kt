package com.tanes

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

        setContentView(R.layout.main_activity)

        Log.i("Life cycle", "onCreate")

        val setTextButton = findViewById<Button>(R.id.set_text_button)
        val typeText = findViewById<EditText>(R.id.type_text)
        val resultText = findViewById<TextView>(R.id.result_text)

        setTextButton.setOnClickListener{
            resultText.text = typeText.editableText.toString()
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
