package com.example.appdev2assignment3.screenUtilities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.appdev2assignment3.utilities.Post
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun PostCard(post: Post) {
    Card (modifier = Modifier.fillMaxWidth().padding(10.dp)) {
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = post.imageUri,
                contentDescription = "profile image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.width(5.dp))
            
            Column {
                Text(
                    text = post.caption
                )
                Text(
                    text = "Likes = ${post.likes}"
                )
                Text(
                    text = "Dislikes = ${post.dislikes}"
                )
                Text(
                    text = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(post.timestamp)
                )
            }
        }
    }
}