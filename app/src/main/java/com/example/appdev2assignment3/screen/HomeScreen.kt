package com.example.appdev2assignment3.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appdev2assignment3.layout.MainLayout
import com.example.appdev2assignment3.screenUtilities.PostCard
import com.example.appdev2assignment3.screenUtilities.ScrollingPostCard
import com.example.appdev2assignment3.utilities.Post

@Composable
fun HomeScreen(posts: List<Post>) {
    MainLayout {
        Column (modifier = Modifier.fillMaxSize()) {
            if (posts.isNotEmpty()) {
                LazyColumn (modifier = Modifier.padding(16.dp)) {
                    items(posts) {
                            post ->
                        ScrollingPostCard(post = post)
                    }
                }                
            }
            else {
                Text(
                    text = "sorry! no posts yet! post something to get the party started!",
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}