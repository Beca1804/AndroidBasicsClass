package com.example.androidbasicsclass.ui.firstpartialpdm1.homeFirstPartialPDM1.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidbasicsclass.ui.firstpartialpdm1.homeFirstPartialPDM1.viewmodel.HomeFirstPartialPDM1ViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment

@Composable
fun HomeFirstPartialPDM1View(
    homeViewModel: HomeFirstPartialPDM1ViewModel = viewModel(),
    navigateToSharedPreferencesExample: () -> Unit = {},
    navigateToJetpackComposeExample: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "First Partial PDM1")

        Button(
            onClick = navigateToSharedPreferencesExample,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Shared Preferences")
        }

        Button(
            onClick = {
                navigateToJetpackComposeExample()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Jetpack Compose Examples")
        }
    }
}