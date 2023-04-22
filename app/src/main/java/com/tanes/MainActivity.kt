package com.tanes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        Log.i("Life cycle", "onCreate")
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
}
