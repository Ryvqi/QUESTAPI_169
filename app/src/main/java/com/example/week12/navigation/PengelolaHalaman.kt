package com.example.week12.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.week12.ui.view.DestinasiDetail
import com.example.week12.ui.view.DestinasiEntry
import com.example.week12.ui.view.DestinasiHome
import com.example.week12.ui.view.DestinasiUpdate
import com.example.week12.ui.view.DetailScreen
import com.example.week12.ui.view.EntryMhsScreen
import com.example.week12.ui.view.HomeScreen
import com.example.week12.ui.view.UpdateScreen

@Composable
fun PengelolaHalaman(modifier: Modifier = Modifier,navController: NavHostController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier,
    ) {
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = {navController.navigate(DestinasiEntry.route)},
                onDetailClick = { nim ->
                    navController.navigate("${DestinasiDetail.route}/$nim")
                }
            )
        }
        composable(DestinasiEntry.route){
            EntryMhsScreen(navigateBack = {
                navController.navigate(DestinasiHome.route){
                    popUpTo(DestinasiHome.route){
                        inclusive = true
                    }
                }
            })
        }
        composable(DestinasiDetail.routeWithArg){backStackEntry ->
            val nim = backStackEntry.arguments?.getString(DestinasiDetail.NIM) ?: ""
            DetailScreen(
                navigateBack = {navController.popBackStack()},
                onUpdateClick = {navController.navigate("${DestinasiUpdate.route}/$nim")}
            )
        }
        composable(DestinasiUpdate.routeWithArg) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString(DestinasiUpdate.NIM) ?: ""
            UpdateScreen(
                navigateBack = { navController.popBackStack() },
            )
        }
    }
}