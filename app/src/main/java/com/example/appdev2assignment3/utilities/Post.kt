package com.example.appdev2assignment3.utilities

import android.net.Uri
import java.sql.Timestamp
import java.util.UUID
import java.util.Date

data class Post(
    val id: String = UUID.randomUUID().toString(),
    var imageUri: Uri?,
    var caption: String,
    var timestamp: Date = Date(),
    var likes: Int = 0,
    var dislikes: Int = 0
)