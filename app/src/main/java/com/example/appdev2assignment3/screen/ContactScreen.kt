package com.example.emptyactivity.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appdev2assignment3.layout.MainLayout
import com.example.appdev2assignment3.utilities.Post

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(onComplaintSent: (String) -> Unit) {
    var email by rememberSaveable { mutableStateOf("Your Email") }
    var problem by rememberSaveable { mutableStateOf("Your Issue") }
    var emailIsEmpty by remember { mutableStateOf(false) }
    var problemIsEmpty by remember { mutableStateOf(false) }

    MainLayout {
        Column {
            if (emailIsEmpty) {
                Text(
                    text = "Please add an email!"
                )
            }
            else if (problemIsEmpty) {
                Text(
                    text = "Please Write what your issue is!"
                )
            }
            OutlinedTextField(
                value = email,
                onValueChange = { newText: String ->
                    email = newText
                },
                label = {
                    Text(
                        "Contact Info:",
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                },
                modifier = Modifier.fillMaxWidth().padding(2.dp)
            )
            OutlinedTextField(
                value = problem,
                onValueChange = { newText: String ->
                    problem = newText
                },
                label = {
                    Text(
                        "Contact Info:",
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                },
                modifier = Modifier.fillMaxWidth().padding(2.dp)
            )
            IconButton(onClick = {
                if (email.isBlank() || email == "Your Email") {
                    email = "Your Email"
                    emailIsEmpty = true
                } else if (problem.isBlank() || problem == "Your Issue") {
                    problem = "Your Issue"
                    problemIsEmpty = true
                    emailIsEmpty = false
                } else {
                    onComplaintSent(email)
                }
            }) {
                Icon(Icons.Default.Send, "Add")
            }
        }
    }
}