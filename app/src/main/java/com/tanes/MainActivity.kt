package com.tanes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tanes.ui.theme.TanesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("Life cycle", "onCreate")

        setContent {
            TanesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
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
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TanesTheme {
        Greeting("Android")
    }
}
