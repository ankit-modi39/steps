
package com.example.steps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.steps.ui.theme.StepsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StepsTheme {
                MyApp(1234)
            }
        }
    }
}

@Composable
fun MyApp(stepsCount:Int) {
    HomeScreen(stepsCount=stepsCount)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StepsTheme {
        MyApp(stepsCount=1234)
    }
}

