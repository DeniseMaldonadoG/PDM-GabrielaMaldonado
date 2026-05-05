package com.example.gdmguno.Pantallas

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row



@Composable
fun nombresPantalla(navController: NavController) {

    var nombre by remember { mutableStateOf("") }
    var listaNombres by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFD1DC))
            .padding(15.dp)
            .systemBarsPadding()
    ) {

        Button(onClick = { navController.popBackStack() }) {
            Text("Regresar")
        }

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Ingrese un nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                if (nombre.isNotBlank()) {
                    listaNombres = listaNombres + nombre
                    nombre = ""
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Guardar nombres")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Listado de nombres y\nposición en la lista",
                fontSize = 18.sp
            )

            Button(
                onClick = {
                    listaNombres = emptyList()
                }
            ) {
                Text("Limpiar")
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(25.dp)
                .border(1.dp, Color.Magenta)
        ) {
            itemsIndexed(listaNombres) { index, item ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = item, fontSize = 20.sp)
                    Text(text = "${index + 1}", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.height(11.dp))
            }
        }
    }
}
