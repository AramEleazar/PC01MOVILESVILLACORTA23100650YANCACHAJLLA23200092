package com.example.pc123100650_23200092.presentation.auth

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PermisoUbicacionScreen(navController: NavHostController) {

    var estadoPermiso by remember {
        mutableStateOf("Permiso pendiente de solicitud")
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { concedido ->

        if (concedido) {
            estadoPermiso = "Permiso concedido"
        } else {
            estadoPermiso = "Permiso denegado"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Permiso de Ubicación",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = estadoPermiso)

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                launcher.launch(
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            }
        ) {
            Text("Solicitar Permiso")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("home")
            }
        ) {
            Text("Volver al menú principal")
        }
    }
}