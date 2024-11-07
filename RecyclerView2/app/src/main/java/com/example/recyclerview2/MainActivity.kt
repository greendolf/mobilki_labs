package com.example.recyclerview2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.recyclerview2.ui.theme.RecyclerView2Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    private val colorsData: ArrayList<ColorData> = ArrayList<ColorData>();
    override fun onCreate(savedInstanceState: Bundle?) {
        for (i in 0..10) {
            val color = Random.nextInt(-16777216, 0)
            colorsData.add(
                ColorData(
                    "Color №${color}",
                    color
                )
            )
        }

        super.onCreate(savedInstanceState)
        setContent {
            RecyclerView2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding), colorsData
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier, colorsData: ArrayList<ColorData>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        items(colorsData) { Item(it.colorName, it.colorHex) }
    }
}

@Composable
fun Item(color: String, hexColor: Int) {
    val context = LocalContext.current
    val onCellClickListener: (color: String) -> Unit = {
        Toast.makeText(
            context,
            "IT’S $color",
            Toast.LENGTH_SHORT
        ).show()
    }

    Row {
        Box(
            modifier = Modifier
                .background(color = Color(hexColor))
                .size(50.dp)
                .clickable {
                    onCellClickListener(color)
                }
        )
        Text(
            text = color,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}

data class ColorData(val colorName: String, val colorHex: Int) {}


