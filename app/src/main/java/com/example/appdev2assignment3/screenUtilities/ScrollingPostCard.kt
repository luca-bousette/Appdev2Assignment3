package com.example.appdev2assignment3.screenUtilities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.appdev2assignment3.utilities.Post

@Composable
fun ScrollingPostCard(post: Post) {
    Card(modifier = Modifier.padding(10.dp)) {
        Column (
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            AsyncImage(
                model = post.imageUri,
                contentDescription = "profile image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().aspectRatio(1f)
                    .clip(RoundedCornerShape(12.dp))
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { post.likes = post.likes + 1 }) {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "like"
                    )
                }

                IconButton(onClick = { post.dislikes = post.dislikes + 1 }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "dislike"
                    )
                }
            }
            Text(
                text = post.caption
            )
        }
    }
}