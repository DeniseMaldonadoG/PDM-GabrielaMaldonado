package com.pdm.laboratorio4.Navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm.laboratorio4.Screens.AddTaskScreen
import com.pdm.laboratorio4.Screens.Mainscreen
import com.pdm.laboratorio4.ViewModel.GeneralViewModel
import kotlinx.serialization.Serializable
import androidx.navigation3.runtime.NavKey

@Serializable
data object TodoRoute : NavKey

@Serializable
data object AddRoute : NavKey

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(TodoRoute)
    val viewModel: GeneralViewModel = viewModel()

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<TodoRoute> {
                Mainscreen(
                    viewModel = viewModel,
                    onNavigateToAdd = { backStack.add(AddRoute) }
                )
            }
            entry<AddRoute> {
                AddTaskScreen(
                    viewModel = viewModel,
                    onNavigateBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}