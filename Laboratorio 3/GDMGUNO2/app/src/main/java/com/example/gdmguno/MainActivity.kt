package com.example.gdmguno

import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gdmguno.Pantallas.pantallaPrincipal
import androidx.navigation.compose.rememberNavController
import com.example.gdmguno.Pantallas.nombresPantalla
import com.example.gdmguno.Pantallas.sensorPantalla



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "principal") {

                composable("principal") {
                    pantallaPrincipal(navController)
                }

                composable("nombres") {
                    nombresPantalla(navController)
                }

                composable("sensor") {
                    sensorPantalla(navController)
                }
            }
        }
    }
}




