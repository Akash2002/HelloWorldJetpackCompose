package com.example.myapplication
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.myapplication.ui.MyApplicationTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Column(Modifier.padding(16.dp)) {
                    val textState = remember { mutableStateOf(TextFieldValue()) }
                    Surface(color = MaterialTheme.colors.background) {
                        OutlinedTextField(value = textState.value,
                                onValueChange = {
                                    textState.value = it
                                },
                                label = { Text(text = "Enter your name") })
                    }
                    Greeting(name = textState.value.text)
                }
            }
        }
    }
}

@Composable
fun registerInput() {
    
}

@Composable // annotation to build composable functions to nest other such functions
fun Greeting(name: String) {
    Surface(color = Color.Cyan) { // declare a yellow background
        Text(text = "Hello $name!")
    } // a composable function from Android Jetpack
}

@Preview(showBackground = true) // annotation to let function run in preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}