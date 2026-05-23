package com.pdm.laboratorio4.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdm.laboratorio4.Screens.AddTaskScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdm.laboratorio4.ViewModel.GeneralViewModel
import com.pdm.laboratorio4.Screens.Mainscreen



@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: GeneralViewModel = viewModel()

    NavHost(navController = navController, startDestination = "todo") {
        composable("todo") {
            Mainscreen  (viewModel = viewModel, onNavigateToAdd = {
                navController.navigate("add")
            })
        }
        composable("add") {
            AddTaskScreen(viewModel = viewModel, onNavigateBack = {
                navController.popBackStack()
            })
        }
    }
}




