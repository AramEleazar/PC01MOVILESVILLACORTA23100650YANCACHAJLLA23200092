package com.example.pc123100650_23200092.presentation.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
            TemporaryScreen(title = "Calculadora de Equipaje", navController = navController)
        }
        composable("budget") {
            TemporaryScreen(title = "Planificador de Presupuesto", navController = navController)
        }
        composable("destinations") {
            TemporaryScreen(title = "Catálogo de Destinos", navController = navController)
        }
        composable("location") {
            TemporaryScreen(title = "Permiso de Ubicación", navController = navController)
        }
    }
}

@Composable
fun TemporaryScreen(title: String, navController: NavHostController) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text("Volver al menú principal")
            }
        }
    }
}
