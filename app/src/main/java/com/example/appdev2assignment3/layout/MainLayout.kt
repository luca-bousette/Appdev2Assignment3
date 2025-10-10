package com.example.appdev2assignment3.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.appdev2assignment3.navigationBar.BottomNavigationBar
import com.example.appdev2assignment3.navigationBar.TopNavigationBar

@Composable
fun MainLayout(content: @Composable () -> Unit) {
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = { TopNavigationBar() },
        bottomBar = { BottomNavigationBar() }
    ) { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)) {
            content()
        }
    }
}