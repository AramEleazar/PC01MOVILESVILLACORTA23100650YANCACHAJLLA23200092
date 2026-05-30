package com.example.pc123100650_23200092

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pc123100650_23200092.presentation.auth.PlanificadorPresupuestos
import com.example.pc123100650_23200092.ui.theme.PC123100650_23200092Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            PC123100650_23200092Theme {
                PlanificadorPresupuestos()
            }
        }
    }
}