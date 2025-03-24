package com.example.projeto.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.projeto.ui.home.HomeDestination
import com.example.projeto.ui.home.HomeScreen


/**
 * Provides Navigation graph for the application.
 */
@Composable
fun CadastroNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(ClienteEntryDestination.route) },
                navigateToItemUpdate = {
                    navController.navigate("${ClienteDetailsDestination.route}/${it}")
                }
            )
        }
        composable(route = ClienteEntryDestination.route) {
            ClienteEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = ClienteDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(ClienteDetailsDestination.clienteIdArg) {
                type = NavType.IntType
            })
        ) {
            ClienteDetailsScreen(
                navigateToEditItem = { navController.navigate("${ClienteEditDestination.route}/$it") },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(
            route = ClienteEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ClienteEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ClienteEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}