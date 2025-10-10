package com.example.appdev2assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appdev2assignment3.navigation.Router
import com.example.appdev2assignment3.ui.theme.Appdev2Assignment3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Appdev2Assignment3Theme {
                Router()
            }
        }
    }
}