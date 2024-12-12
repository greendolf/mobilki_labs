package com.example.cotiki3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.cotiki3.ui.theme.Cotiki3Theme
import timber.log.Timber
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.launch


enum class AppScreens(val title: String) {
    Main(title = "GSON"),
    Image(title = "GSON Image")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cotiki3Theme {
                App()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    currentScreen: AppScreens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    addToFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    TopAppBar(

        title = { Text(currentScreen.title) },
        modifier = modifier.background(color = Color.Blue),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.White,
        ),
        navigationIcon = {
            if (canNavigateBack && currentScreen != AppScreens.Main) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        },
        actions = {
            if (currentScreen == AppScreens.Image) {
                IconButton(onClick = {
                    addToFavorite()
                    Toast.makeText(
                        context,
                        "Добавлено в избранное",
                        Toast.LENGTH_SHORT
                    ).show()
                }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Logout"
                    )
                }
            }
        }
    )
}


@Composable
fun App(
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppScreens.valueOf(
        backStackEntry?.destination?.route ?: AppScreens.Main.name
    )
    val viewModel: PhotosViewModel = viewModel()
    val snackbarHostState = remember { SnackbarHostState() }

    fun addToFavorite() {
        viewModel.setFavorite()
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            AppBar(
                addToFavorite = { addToFavorite() },
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreens.Main.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = AppScreens.Main.name) {
                MainScreen(navController = navController, viewModel, snackbarHostState)
            }
            composable(route = AppScreens.Image.name) {
                ImageScreen(navController = navController, viewModel)
            }

        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: PhotosViewModel,
    snackbarHostState: SnackbarHostState
) {
    val uiState by viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    fun onClick(link: String) {
        viewModel.setLink(link)
        navController.navigate("image")
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        items(uiState.links) { link ->
            Timber.tag("API_RESPONSE").d("Request failed: %s", link)
            AsyncImage(
                model = link,
                contentDescription = "aaa",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clickable(onClick = { onClick(link) }),
            )
        }

    }
    if (uiState.favoriteImage !== "") {
        val link = uiState.favoriteImage
        scope.launch {
            val res = snackbarHostState
                .showSnackbar(
                    message = "Картинка добавлена в избранное",
                    actionLabel = "Открыть",
                    duration = SnackbarDuration.Short
                )
            if (res == SnackbarResult.ActionPerformed) {
                val customTabsIntent = CustomTabsIntent.Builder().build()
                customTabsIntent.launchUrl(context, android.net.Uri.parse(link))
            }

        }
        viewModel.clearFavorite()
    }
}

@Composable
fun ImageScreen(navController: NavController, viewModel: PhotosViewModel) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val imageSize = screenWidth * 0.9f

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        AsyncImage(
            model = uiState.currentImage,
            contentDescription = "aaa",
            modifier = Modifier
                .size(imageSize)
        )
    }
}
