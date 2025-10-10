package com.example.appdev2assignment3.navigationBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.appdev2assignment3.navigation.LocalNavController

@Composable
fun BottomNavigationBar() {
    val navController = LocalNavController.current
    BottomAppBar (
        content = {
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { navController.navigate("ContactScreenRoute") }) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Navigate back"
                    )
                }
                IconButton(onClick = { navController.navigate("HomeScreenRoute") }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Navigate back"
                    )
                }
                IconButton(onClick = { navController.navigate("CreateEditScreenRoute/newScreen") }) {
                    Icon(
                        imageVector = Icons.Filled.AddCircle,
                        contentDescription = "Navigate back"
                    )
                }
            }

        },
        modifier = Modifier.fillMaxWidth()
    )
}