package com.example.pc123100650_23200092.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pc123100650_23200092.presentation.auth.CatalogoDestinos
import com.example.pc123100650_23200092.presentation.auth.PlanificadorPresupuestos
import com.example.pc123100650_23200092.presentation.auth.PermisoUbicacionScreen
import com.example.pc123100650_23200092.presentation.home.HomeScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController)
        }

        composable("luggage") {
            PermisoUbicacionScreen(navController)
        }

        composable("budget") {
            PlanificadorPresupuestos(navController)
        }

        composable("destinations") {
            CatalogoDestinos(navController)
        }

        composable("location") {
            PermisoUbicacionScreen(navController)
        }
    }
}