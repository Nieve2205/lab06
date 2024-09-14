package com.example.template.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun UserProfileScreen() {
        Log.d("Navigation", "Navigating to profile")
        Text(
                text = "Esta es la pantalla de perfil de usuario",
                modifier = Modifier.fillMaxSize()
        )
}
