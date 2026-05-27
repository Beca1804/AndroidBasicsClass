package com.example.androidbasicsclass.ui.thirdpartiallids2.homeThirdPartialIDS2.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeThirdPartialIDS2View(
    onApiRequestClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Third Partial IDS2")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onApiRequestClick
        ) {
            Text(text = "API Request")
        }
    }
}