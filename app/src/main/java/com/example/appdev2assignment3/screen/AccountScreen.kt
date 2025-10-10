package com.example.appdev2assignment3.screen

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.appdev2assignment3.layout.MainLayout
import com.example.appdev2assignment3.screenUtilities.PostCard
import com.example.appdev2assignment3.screenUtilities.ProfileImage
import com.example.appdev2assignment3.utilities.Post
import androidx.compose.foundation.lazy.items

@Composable
fun AccountScreen(profileURI: Uri?, onImageChange: (Uri?) -> Unit, 
                  username: String, onNameChange: (String) -> Unit,
                  description: String, onDescriptChange: (String) -> Unit,
                  posts: List<Post>) {
    val MAX_NAME_LENGTH = 24
    
    MainLayout {
        Column (
            modifier = Modifier.fillMaxSize()
        ) {
            Column (Modifier.background(Color.Blue) ) {
                Row (modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                    Box (modifier = Modifier.weight(1f).aspectRatio(1f)) {
                        ProfileImage(profileURI, onImageChange)
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    OutlinedTextField(
                        value = username,
                        onValueChange = {newText: String ->
                            if (newText.length <= MAX_NAME_LENGTH) {
                                onNameChange(newText)
                            }
                        },
                        modifier = Modifier.weight(4f).fillMaxWidth(),
                        label = { Text(username) },
                        singleLine = true
                    )
                }

                TextField(
                    value = description,
                    onValueChange = {newText: String ->
                        onDescriptChange(newText)
                    },
                    modifier = Modifier.fillMaxWidth().padding(10.dp).height(150.dp),
                    label = { Text("Description") },
                )
            }
            Column {
                LazyColumn { 
                    items(posts) {
                        post ->
                        PostCard(post = post)
                    }
                }
            }
        }
    }
}