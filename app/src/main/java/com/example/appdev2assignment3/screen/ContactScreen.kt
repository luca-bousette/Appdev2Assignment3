package com.example.appdev2assignment3.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.appdev2assignment3.layout.MainLayout

@Composable
fun ContactScreen() {
    MainLayout {
        Column {
            Text(
                text = "Contact us at three@threemail.com"
            )
        }
    }
}