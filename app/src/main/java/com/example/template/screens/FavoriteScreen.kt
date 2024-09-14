package com.example.template.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FavoriteScreen() {
    Log.d("Navigation", "Navigating to favorite")
    Text(
        text = "Favorite Screen",
        modifier = Modifier.fillMaxSize()
    )
}
