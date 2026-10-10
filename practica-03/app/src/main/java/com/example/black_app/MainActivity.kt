package com.example.black_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.black_app.ui.theme.Black_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Black_appTheme {
                Black_appApp()
            }
        }
    }
}

@Composable
fun Black_appApp() {
    var currentDestination by rememberSaveable {
        mutableStateOf(AppDestinations.HOME)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                AppDestinations.entries.forEach { destination ->
                    NavigationBarItem(
                        icon = {
                            Text(text = destination.label.take(1))
                        },
                        label = {
                            Text(destination.label)
                        },
                        selected = currentDestination == destination,
                        onClick = {
                            currentDestination = destination
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentDestination) {
                AppDestinations.HOME -> Greeting()
                AppDestinations.FAVORITES -> Practica2()
                AppDestinations.PROFILE -> Practica3()
            }
        }
    }
}

enum class AppDestinations(val label: String) {
    HOME("Home"),
    FAVORITES("Favorites"),
    PROFILE("Profile")
}

@Composable
fun Greeting() {
    Text(text = "Texto prueba")
}

@Composable
fun Practica2() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF424242))
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.icono),
                contentDescription = "Icono",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )

            Text(
                text = "Gisel Ponce Meneses",
                fontSize = 32.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun Practica3() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF424242))
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.icono),
                contentDescription = "Imagen del producto",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            )

            Text(
                text = "Gisel Ponce Meneses",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Text(
                text = "TIID 04_01",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Aplicaciones móviles",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                items(
                    listOf(
                        "Stack:",
                        "Java",
                        "KOTLIN"
                    )
                ) { texto ->
                    Text(
                        text = texto,
                        color = Color.White,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                }
            }
        }
    }
}