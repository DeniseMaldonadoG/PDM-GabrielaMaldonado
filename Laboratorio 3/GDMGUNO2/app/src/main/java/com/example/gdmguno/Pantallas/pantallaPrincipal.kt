package com.example.gdmguno.Pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.navigation.NavController
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height


@Composable
fun pantallaPrincipal(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = { navController.navigate("nombres") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver lista de nombres")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("sensor") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver sensores")
        }
    }
}
