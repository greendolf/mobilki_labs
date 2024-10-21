package com.example.complexevent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.complexevent.ui.theme.ComplexEventTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComplexEventTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Form(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

class FormViewModel : ViewModel() {
    var progress by mutableFloatStateOf(0.0f)
    var check by mutableStateOf(false)
    var text by mutableStateOf("")

    private fun increaseProgress() {
        progress += 0.1f
    }

    fun saveText(new: String) {
        text = new
        increaseProgress()
    }

    fun checkChange() {
        check = !check
    }
}

@Composable
fun Form(modifier: Modifier, vm: FormViewModel = viewModel()) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = text, onValueChange = { new -> text = new }, placeholder = {})
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = vm.check, onCheckedChange = { vm.checkChange() })
            Text("Точно сохранить?")
        }
        Button(onClick = { if (vm.check) vm.saveText(text) }) { Text("СОХРАНИТЬ") }
        Text(vm.text)
        LinearProgressIndicator(
            progress = { vm.progress },
        )
    }
}
