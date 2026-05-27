package com.example.androidbasicsclass.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.material.icons.outlined.PhoneAndroid
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidbasicsclass.ui.firstpartialpdm1.homeFirstPartialPDM1.view.HomeFirstPartialPDM1View
import com.example.androidbasicsclass.ui.login.LoginScreen
import com.example.androidbasicsclass.ui.personalinformation.homePersonalinformation.view.HomePersonalInformationView
import com.example.androidbasicsclass.ui.secondpartialpdm1.homeSecondPartialPDM1.view.HomeSecondPartialPDM1View
import com.example.androidbasicsclass.ui.thirdpartiallids2.firstapirequest.view.FirstApiRequestView
import com.example.androidbasicsclass.ui.thirdpartiallids2.homeThirdPartialIDS2.view.HomeThirdPartialIDS2View
import com.example.androidbasicsclass.ui.thirdpartialpdm1.homeThirdPartialPDM1.view.HomeThirdPartialPDM1View

sealed class AppRoute(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object ThirdPartialIDS2 : AppRoute(
        route = "third_partial_ids2",
        label = "IDS2 P3",
        icon = Icons.Filled.School
    )

    object FirstPartialPDM1 : AppRoute(
        route = "first_partial_pdm1",
        label = "PDM1 P1",
        icon = Icons.Filled.PhoneAndroid
    )

    object SecondPartialPDM1 : AppRoute(
        route = "second_partial_pdm1",
        label = "PDM1 P2",
        icon = Icons.Outlined.PhoneAndroid
    )

    object ThirdPartialPDM1 : AppRoute(
        route = "third_partial_pdm1",
        label = "PDM1 P3",
        icon = Icons.Filled.Smartphone
    )

    object PersonalInformation : AppRoute(
        route = "personal_information",
        label = "About Me",
        icon = Icons.Filled.Person
    )
}

private val TABS = listOf(
    AppRoute.ThirdPartialIDS2,
    AppRoute.FirstPartialPDM1,
    AppRoute.SecondPartialPDM1,
    AppRoute.ThirdPartialPDM1,
    AppRoute.PersonalInformation
)

@Composable
fun AppNavigation() {
    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onLoginClick = {
                    rootNavController.navigate("tabs") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable("tabs") {
            TabsScreen(
                onApiRequestClick = {
                    rootNavController.navigate("first_api_request")
                }
            )
        }

        composable("first_api_request") {
            FirstApiRequestView(
                onBackClick = {
                    rootNavController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun TabsScreen(
    onApiRequestClick: () -> Unit
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                TABS.forEach { tab ->
                    NavigationBarItem(
                        selected = currentRoute == tab.route,
                        onClick = {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = tab.label
                            )
                        },
                        label = {
                            Text(
                                text = tab.label,
                                fontSize = 10.sp
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppRoute.ThirdPartialIDS2.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppRoute.ThirdPartialIDS2.route) {
                HomeThirdPartialIDS2View(
                    onApiRequestClick = onApiRequestClick
                )
            }

            composable(AppRoute.FirstPartialPDM1.route) {
                HomeFirstPartialPDM1View()
            }

            composable(AppRoute.SecondPartialPDM1.route) {
                HomeSecondPartialPDM1View()
            }

            composable(AppRoute.ThirdPartialPDM1.route) {
                HomeThirdPartialPDM1View()
            }

            composable(AppRoute.PersonalInformation.route) {
                HomePersonalInformationView()
            }
        }
    }
}
