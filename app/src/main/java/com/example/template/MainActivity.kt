package com.example.template

import android.os.Bundle
import com.example.template.screens.UserProfileScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.template.ui.theme.TemplateTheme
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.template.screens.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TemplateTheme {
                CustomScaffold()
            }
        }
    }
}

@Composable
fun CustomScaffold() {
    val navController = rememberNavController()
    var clickCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { CustomTopBar(navController) },
        bottomBar = { CustomBottomBar(navController) },
        floatingActionButton = {
            CustomFAB(onClick = { clickCount++ })
        },
        content = { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "main",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("main") {
                    CustomContent(clickCount = clickCount)
                }
                composable("profile") { UserProfileScreen() }
                composable("build") { BuildScreen() }
                composable("menu") { MenuScreen() }
                composable("favorite") { FavoriteScreen() }
                composable("delete") { DeleteScreen() }
            }
        }
    )
}

@Composable
fun CustomContent(clickCount: Int, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Botón presionado $clickCount veces")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavHostController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /* TODO */ }) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = null,
                    tint = Color(0xFF3729F8)
                )
            }
        },
        title = { Text(text = "Sample Title") },
        actions = {
            IconButton(onClick = { /* TODO */ }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null,
                    tint = Color(0xFF3729F8)
                )
            }
            IconButton(onClick = {
                navController.navigate("profile")
            }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null,
                    tint = Color(0xFF3729F8)
                )
            }
        }
    )
}

@Composable
fun CustomBottomBar(navController: NavHostController) {
    BottomAppBar {
        IconButton(
            onClick = { navController.navigate("build") },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                Icons.Filled.Build,
                contentDescription = "Build description",
                tint = Color(0xFF3729F8)
            )
        }
        IconButton(
            onClick = { navController.navigate("menu") },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                Icons.Filled.Menu,
                contentDescription = "Menu description",
                tint = Color(0xFF3729F8)
            )
        }
        IconButton(
            onClick = { navController.navigate("favorite") },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite description",
                tint = Color(0xFF3729F8)
            )
        }
        IconButton(
            onClick = { navController.navigate("delete") },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                Icons.Filled.Delete,
                contentDescription = "Delete description",
                tint = Color(0xFF3729F8)
            )
        }
    }
}

@Composable
fun CustomFAB(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            fontSize = 24.sp,
            text = "+"
        )
    }
}