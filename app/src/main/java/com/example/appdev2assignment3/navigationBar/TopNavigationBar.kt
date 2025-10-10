package com.example.appdev2assignment3.navigationBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.appdev2assignment3.navigation.LocalNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar() {
    val navController = LocalNavController.current
    TopAppBar(
        title = { Text(text = "Memeoryio") },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Navigate back"
                )
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate("AccountScreenRoute/") }) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Navigate back"
                )
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}
