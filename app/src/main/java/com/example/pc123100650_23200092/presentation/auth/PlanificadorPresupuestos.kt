package com.example.pc123100650_23200092.presentation.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PlanificadorPresupuestos(navController: NavHostController) {

    var dias by remember { mutableStateOf("") }
    var presupuesto by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }
    var alojamiento by remember { mutableStateOf("Económico") }

    var resultado by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Button(
            onClick = {
                navController.navigate("home")
            }
        ) {
            Text("Volver al menú principal")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Planificador de Presupuesto de Viaje",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = dias,
            onValueChange = { dias = it },
            label = { Text("Cantidad de días") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = presupuesto,
            onValueChange = { presupuesto = it },
            label = { Text("Presupuesto diario") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { expanded = true }
        ) {
            Text(alojamiento)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {

            DropdownMenuItem(
                text = { Text("Económico") },
                onClick = {
                    alojamiento = "Económico"
                    expanded = false
                }
            )

            DropdownMenuItem(
                text = { Text("Estándar") },
                onClick = {
                    alojamiento = "Estándar"
                    expanded = false
                }
            )

            DropdownMenuItem(
                text = { Text("Premium") },
                onClick = {
                    alojamiento = "Premium"
                    expanded = false
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

                if (dias.isEmpty() || presupuesto.isEmpty()) {

                    resultado = "Complete todos los campos"
                    descripcion = ""

                } else {

                    val d = dias.toIntOrNull()
                    val p = presupuesto.toDoubleOrNull()

                    if (d == null || p == null) {

                        resultado = "Ingrese valores numéricos válidos"
                        descripcion = ""

                    } else if (d <= 0) {

                        resultado = "Los días deben ser mayores a cero"
                        descripcion = ""

                    } else if (p <= 0) {

                        resultado = "El presupuesto debe ser mayor a cero"
                        descripcion = ""

                    } else {

                        var factor = 0.8

                        if (alojamiento == "Estándar") {
                            factor = 1.0
                        }

                        if (alojamiento == "Premium") {
                            factor = 1.5
                        }

                        val total = d * p * factor

                        resultado =
                            "Presupuesto Total: ${"%.2f".format(total)}"

                        descripcion =
                            "Viaje de $d días con alojamiento $alojamiento."
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(resultado)

        Spacer(modifier = Modifier.height(8.dp))

        Text(descripcion)
    }
}