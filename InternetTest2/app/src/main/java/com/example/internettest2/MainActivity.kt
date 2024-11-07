package com.example.internettest2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.internettest2.ui.theme.InternetTest2Theme
import okhttp3.OkHttpClient
import okhttp3.Request


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InternetTest2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }

            }
        }
    }


    @Composable
    fun MainScreen(modifier: Modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    Thread {
                        val url =
                            "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1"
                        val client = OkHttpClient.Builder().build()

                        val request = Request.Builder()
                            .url(url)
                            .build()
                        val response = client.newCall(request).execute()

                        if (response.isSuccessful) {
                            response.body.string().let { Log.d("Flickr OkCats", it) }
                        }
                    }.start()
                }
            ) { Text(text = "Get via OkHTTP") }
        }
    }
}