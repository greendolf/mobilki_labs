package com.example.nestedlayouts2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nestedlayouts2.ui.theme.NestedLayouts2Theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NestedLayouts2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Components(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

class ComponentsViewModel : ViewModel() {
    var count by mutableIntStateOf(1)

    fun increase() {
        count++
    }
}


@Composable
fun Components(modifier: Modifier, vm: ComponentsViewModel = viewModel()) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextRow(vm.count)
        TextColumn(vm.count)
        TextTriangle(vm.count)
        Button(onClick = { vm.increase() }) { Text("Roll!") }
    }
}

@Composable
fun TextRow(count: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.background(Color.White),
            text = if (count % 3 == 1) count.toString() else ""
        )
        Text(
            modifier = Modifier.background(Color.White),
            text = if (count % 3 == 2) count.toString() else ""
        )
        Text(
            modifier = Modifier.background(Color.White),
            text = if (count % 3 == 0) count.toString() else ""
        )
    }
}

@Composable
fun TextColumn(count: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.background(Color.White),
            text = if (count % 3 == 1) count.toString() else ""
        )
        Text(
            modifier = Modifier.background(Color.White),
            text = if (count % 3 == 2) count.toString() else ""
        )
        Text(
            modifier = Modifier.background(Color.White),
            text = if (count % 3 == 0) count.toString() else ""
        )
    }
}

@Composable
fun TextTriangle(count: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                modifier = Modifier
                    .padding(PaddingValues(horizontal = 20.dp))
                    .background(Color.White),
                text = if (count % 3 == 1) count.toString() else ""
            )
            Text(
                modifier = Modifier
                    .padding(PaddingValues(horizontal = 20.dp))
                    .background(Color.White),
                text = if (count % 3 == 2) count.toString() else ""
            )
        }
        Text(
            modifier = Modifier
                .padding(PaddingValues(horizontal = 20.dp))
                .background(Color.White),
            text = if (count % 3 == 0) count.toString() else ""
        )
    }
}
