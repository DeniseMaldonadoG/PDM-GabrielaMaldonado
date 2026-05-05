package com.example.gdmguno.Pantallas

import android.hardware.Sensor
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.navigation.NavController
import androidx.compose.material3.Button
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import com.example.gdmguno.useSensor


@Composable
fun sensorPantalla(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = { navController.popBackStack() }) {
            Text("Regresar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Este sensor detecta cuando un objeto está cerca de la pantalla del dispositivo. Su función principal es:\n" +
                "\n" +
                "- Apagar la pantalla durante llamadas telefónicas cuando el dispositivo está cerca del rostro\n" +
                "- Prevenir toques accidentales\n" +
                "- Ahorrar batería")
    }
    ProximitySensor()
}

@Composable
fun ProximitySensor () {
    val proximityValues = useSensor(Sensor.TYPE_PROXIMITY)

    Scaffold { innerPadding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sensor de Proximidad", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "Distancia:${proximityValues[0]} cm", fontSize = 18.sp)
        }
    }
}
