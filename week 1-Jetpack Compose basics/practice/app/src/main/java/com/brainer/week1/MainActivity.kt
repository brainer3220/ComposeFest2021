package com.brainer.week1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brainer.week1.ui.theme.Week1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
private fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        Greeting("Android")
    }
}

@Composable
private fun Greeting(name: String) {
    val isColorChange = remember { mutableStateOf(false) }
    val colorChange = if (isColorChange.value) MaterialTheme.colors.primary else Color.White

    val isTureView = remember { mutableStateOf(true) }

    if (isTureView.value) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Button(onClick = { isTureView.value = !isTureView.value }) {
                Text(modifier = Modifier.padding(32.dp), text = "If true view")
            }
        }
    } else {
        Surface(color = colorChange) {
            LazyColumn {
                item {
                    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
                    Text("First row", modifier = Modifier.padding(24.dp))
                    Text("Second row", modifier = Modifier.padding(24.dp))

                    Row(modifier = Modifier.padding(24.dp)) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "Hello, ")
                            Text(text = name)
                        }
                        OutlinedButton(
                            onClick = { isColorChange.value = !isColorChange.value },
                        ) {
                            Text(if (isColorChange.value) "Show white" else "Show purple")
                        }
                    }
                    Button(onClick = { isTureView.value = !isTureView.value }, modifier = Modifier.padding(24.dp)) {
                        Text(text = "Show first view")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    Week1Theme {
        MyApp()
    }
}
