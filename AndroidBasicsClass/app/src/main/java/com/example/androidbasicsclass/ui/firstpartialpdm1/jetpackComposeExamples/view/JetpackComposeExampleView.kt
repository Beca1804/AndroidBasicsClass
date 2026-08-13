package com.example.androidbasicsclass.ui.firstpartialpdm1.jetpackComposeExamples.view
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun JetPackComposeExamplesView() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(text = "Jetpack")

        Text(
            text = "Rebeca Garcia",
            color = Color.Red,
            fontSize = 30.sp
        )
    }
}

@Preview
@Composable
fun JetPackComposeExamplesViewPreview() {
    JetPackComposeExamplesView()
}
