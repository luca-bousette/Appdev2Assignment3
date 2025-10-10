package com.example.appdev2assignment3.screenUtilities

import androidx.compose.runtime.Composable
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProfileImage(
    imageURI: Uri?,
    onChange: (Uri?) -> Unit
) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { 
        uri ->
        if (uri != null) {
            onChange(uri)
        }
    }

    Box(
        modifier = Modifier.clip(CircleShape).clickable { launcher.launch("image/*") }
            .border(width = 2.dp, shape = CircleShape, color = Color.Black)
    ) {
        if (imageURI != null) {
            AsyncImage(
                model = imageURI,
                contentDescription = "profile image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        else {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "profile image",
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}