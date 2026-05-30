package com.example.pc123100650_23200092.presentation.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CalculadoraEquipaje(navController: NavHostController) {

    var peso by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }
    var tipoVuelo by remember { mutableStateOf("Nacional") }

    var resultado by remember { mutableStateOf("") }

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
            text = "Calculadora de Equipaje",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso de la maleta (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                expanded = true
            }
        ) {
            Text(tipoVuelo)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {

            DropdownMenuItem(
                text = { Text("Nacional") },
                onClick = {
                    tipoVuelo = "Nacional"
                    expanded = false
                }
            )

            DropdownMenuItem(
                text = { Text("Internacional") },
                onClick = {
                    tipoVuelo = "Internacional"
                    expanded = false
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

                if (peso.isEmpty()) {

                    resultado = "Ingrese el peso de la maleta"

                } else {

                    val pesoMaleta = peso.toDoubleOrNull()

                    if (pesoMaleta == null) {

                        resultado = "Ingrese un valor numérico válido"

                    } else if (pesoMaleta <= 0) {

                        resultado = "El peso debe ser mayor a cero"

                    } else {

                        var limite = 23.0

                        if (tipoVuelo == "Internacional") {
                            limite = 32.0
                        }

                        if (pesoMaleta <= limite) {

                            resultado =
                                "Cumple el límite permitido ($limite kg)"

                        } else {

                            val excedido = pesoMaleta - limite

                            resultado =
                                "Excede el límite permitido. Exceso: ${"%.2f".format(excedido)} kg"
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Verificar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(resultado)
    }
}