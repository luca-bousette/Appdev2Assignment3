package com.example.appdev2assignment3.navigation

import android.net.Uri
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appdev2assignment3.screen.AccountScreen
import com.example.appdev2assignment3.screen.CreateEditScreen
import com.example.appdev2assignment3.screen.HomeScreen
import com.example.appdev2assignment3.utilities.Post
import com.example.emptyactivity.screens.ContactScreen

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
                    HomeScreen(posts)
                }
                composable("ContactScreenRoute") {
                    ContactScreen({ email ->
                        navController.navigate("AccountScreenRoute/A message wasn't sent to ${email}!")
                    })
                }
                composable("AccountScreenRoute/{popup}") {
                    val popup = it.arguments?.getString("popup") ?: ""
                    AccountScreen(profileImage, {profileImage = it},
                        username, {username = it},
                        description, {description = it},
                        posts, popup)
                }
                composable("CreateEditScreenRoute/{id}") {
                    val id = it.arguments?.getString("id")
                    CreateEditScreen(id, 
                        posts,
                        { newPost -> 
                            posts = posts + newPost
                            navController.navigate("AccountScreenRoute/${newPost.caption} created!")
                        })
                }
            }
        }
    }
}