package com.example.recyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.recyclerview.ui.theme.RecyclerViewTheme

import kotlin.random.Random

class MainActivity : ComponentActivity() {
    private val colors = ArrayList<ColorData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        for (i in 1..9) {
            val color = Random.nextInt(-16777216, 0)
            colors.add(
                ColorData(
                    "Color №${color}",
                    color
                )
            )
        }

        super.onCreate(savedInstanceState)
        setContent {
            RecyclerViewTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding), colors
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier, colors: ArrayList<ColorData>) {


    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(colors) {
            Card(it)
        }
    }
}

@Composable
fun Card(cd: ColorData) {
    Row(modifier = Modifier.padding(top = 15.dp)) {
        Box(
            modifier = Modifier
                .background(color = Color(cd.hexColor))
                .size(50.dp)
        )
        Text(cd.color, modifier = Modifier.padding(start = 15.dp))
    }
}

data class ColorData(val color: String, val hexColor: Int)