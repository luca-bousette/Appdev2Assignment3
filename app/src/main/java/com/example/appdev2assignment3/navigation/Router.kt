package com.example.appdev2assignment3.navigation

import android.net.Uri
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appdev2assignment3.screen.AccountScreen
import com.example.appdev2assignment3.screen.ContactScreen
import com.example.appdev2assignment3.screen.CreateEditScreen
import com.example.appdev2assignment3.screen.HomeScreen
import com.example.appdev2assignment3.utilities.Post

val LocalNavController = compositionLocalOf<NavController> { error("No NavController found!") }

@Composable
fun Router() {
    val navController = rememberNavController()

    var posts by remember { mutableStateOf(listOf<Post>()) }

    var profileImage by remember { mutableStateOf<Uri?>(null) }
    var username by remember { mutableStateOf("Nameless") }
    var description by remember { mutableStateOf("Describe Yourself!") }

    Column {
        CompositionLocalProvider(LocalNavController provides navController) {
            NavHost(
                navController = navController,
                enterTransition = { fadeIn() },
                exitTransition = { fadeOut() },
                startDestination = "CreateEditScreenRoute/"
            ) {
                composable("HomeScreenRoute") {
                    HomeScreen()
                }
                composable("ContactScreenRoute") {
                    ContactScreen()
                }
                composable("AccountScreenRoute") {
                    AccountScreen(profileImage, {profileImage = it},
                        username, {username = it},
                        description, {description = it},
                        posts)
                }
                composable("CreateEditScreenRoute/{id}") {
                    val id = it.arguments?.getString("id")
                    CreateEditScreen(id, 
                        posts,
                        { newPost -> 
                            posts = posts + newPost
                            navController.navigate("AccountScreenRoute")
                        })
                }
            }
        }
    }
}