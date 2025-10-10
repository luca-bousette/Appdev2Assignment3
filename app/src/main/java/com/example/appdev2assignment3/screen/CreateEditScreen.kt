package com.example.appdev2assignment3.screen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.appdev2assignment3.layout.MainLayout
import com.example.appdev2assignment3.utilities.Post

//IMPORTANT NOTICE: taking from apps like instagram, if you leave the uploading page it does not save what you were creating
@Composable
fun CreateEditScreen(id: String?, posts: List<Post>, onPostCreated: (Post) -> Unit) {
    var postImageURI by remember { mutableStateOf<Uri?>(null) }
    var caption by remember { mutableStateOf("") }
    var imageIsEmpty by remember { mutableStateOf(false) }
    var captionIsEmpty by remember { mutableStateOf(false) }
    
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        uri ->
        if (uri != null) {
            postImageURI = uri
        }
    }

    MainLayout {
        Column (
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            if (imageIsEmpty) {
                Text(
                    text = "Please Insert An Image!"
                )
            }
            else if (captionIsEmpty) {
                Text(
                    text = "Please Write A Caption!"
                )
            }
            
            Box(
                modifier = Modifier.clickable { launcher.launch("image/*") }
                    .border(width = 2.dp, color = Color.Black).aspectRatio(1f)
            ) {
                if (postImageURI != null) {
                    AsyncImage(
                        model = postImageURI,
                        contentDescription = "profile image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                else {
                    Icon(
                        imageVector = Icons.Filled.Create,
                        contentDescription = "profile image",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(10.dp)
            )
            
            TextField(
                value = caption,
                onValueChange = {newText: String ->
                    caption = newText
                },
                modifier = Modifier.fillMaxWidth().height(150.dp),
                label = { Text("Caption") }
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            
            Button(onClick = {
                if (postImageURI == null) {
                    imageIsEmpty = true
                } else if (caption.isBlank()) {
                    captionIsEmpty = true
                    imageIsEmpty = false
                } else {
                    val newPost = Post(
                        imageUri = postImageURI,
                        caption = caption
                    )
                    onPostCreated(newPost)
                }
            },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Create Post"
                )
            }
        }
    }
}