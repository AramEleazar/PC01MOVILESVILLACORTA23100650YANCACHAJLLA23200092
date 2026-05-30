package com.example.pc123100650_23200092.presentation.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.pc123100650_23200092.data.model.Destination

@Composable
fun CatalogoDestinos(navController: NavHostController) {

    val destinos = listOf(

        Destination(
            "Perú",
            "Cusco",
            1200.0,
            "https://picsum.photos/300/200?1"
        ),

        Destination(
            "Francia",
            "París",
            2500.0,
            "https://picsum.photos/300/200?2"
        ),

        Destination(
            "Japón",
            "Tokio",
            3200.0,
            "https://picsum.photos/300/200?3"
        ),

        Destination(
            "Brasil",
            "Rio de Janeiro",
            1800.0,
            "https://picsum.photos/300/200?4"
        ),

        Destination(
            "Estados Unidos",
            "Nueva York",
            2800.0,
            "https://picsum.photos/300/200?5"
        )
    )

    val sumaCostos = destinos.sumOf { it.costo }

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

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            items(destinos) { destino ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                ) {

                    Row(
                        modifier = Modifier.padding(10.dp)
                    ) {

                        AsyncImage(
                            model = destino.imagen,
                            contentDescription = destino.ciudad,
                            modifier = Modifier.size(100.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Column {

                            Text("País: ${destino.pais}")

                            Text("Ciudad: ${destino.ciudad}")

                            Text("Costo promedio: S/. ${destino.costo}")
                        }
                    }
                }
            }

            item {

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Cantidad total de destinos: ${destinos.size}"
                )

                Text(
                    text = "Suma acumulada de costos: S/. $sumaCostos"
                )
            }
        }
    }
}