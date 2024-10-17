package com.example.attributes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.attributes.ui.theme.AttributesTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AttributesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var textColor by remember { mutableStateOf(Color.Black) }
    var textSize by remember { mutableStateOf(8.sp) }
    var backgroundColor by remember { mutableStateOf(Color.White) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            textStyle = TextStyle(
                color = textColor,
                fontSize = textSize,
                background = backgroundColor
            ),
        )
        Row {
            Button(onClick = { textColor = Color.Black }) { Text("ЧЕРНЫЙ ТЕКСТ") }
            Button(onClick = { textColor = Color.Red }) { Text("КРАСНЫЙ ТЕКСТ") }
        }
        Row {
            Button(onClick = { textSize = 8.sp }) { Text("РАЗМЕР - 8SP") }
            Button(onClick = { textSize = 24.sp }) { Text("РАЗМЕР - 24SP") }
        }
        Row {
            Button(onClick = { backgroundColor = Color.White }) { Text("БЕЛЫЙ ФОН") }
            Button(onClick = { backgroundColor = Color.Yellow }) { Text("ЖЕЛТЫЙ ФОН") }
        }
    }
}

