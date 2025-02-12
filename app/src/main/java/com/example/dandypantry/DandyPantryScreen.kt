package com.example.dandypantry

import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.dandypantry.ui.CreateItemScreen
import com.example.dandypantry.ui.DandyPantryViewModel
import com.example.dandypantry.ui.DeleteItemConfirmationScreen
import com.example.dandypantry.ui.EditItemScreen
import com.example.dandypantry.ui.ItemViewScreen
import com.example.dandypantry.ui.InventoryScreen
import com.example.dandypantry.ui.StartScreen


// this is the file for navigating between pages
// establish routes, etc
enum class DandyPantryScreen() {
    Start,
    Create,
    Read,
    Update,
    Delete,
    Inventory
}

@Composable
fun DandyPantryApp(
    viewModel: DandyPantryViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = DandyPantryScreen.valueOf(
        backStackEntry?.destination?.route ?: DandyPantryScreen.Start.name
    )

    Scaffold(

    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = DandyPantryScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = DandyPantryScreen.Start.name) {
                val activity = LocalActivity.current
                StartScreen(
                    onNextButtonClicked = { screen ->
                        navController.navigate(screen.name)
                    },
                    onExitClicked = {
                        // Exit the app
                        activity?.finish()
                    }
                )
            }
            composable(route = DandyPantryScreen.Read.name) {
                ItemViewScreen()
            }
            composable(route = DandyPantryScreen.Create.name) {
                CreateItemScreen()
            }
            composable(route = DandyPantryScreen.Update.name) {
                EditItemScreen()
            }
            composable(route = DandyPantryScreen.Delete.name) {
                DeleteItemConfirmationScreen()
            }
            composable(route = DandyPantryScreen.Inventory.name) {
                InventoryScreen()
            }
        }

    }
}

private fun cancelAndNavigateToStart(
    viewModel: DandyPantryViewModel,
    navController: NavHostController
) {
    viewModel.resetSku()
    navController.popBackStack(DandyPantryScreen.Start.name, inclusive = false)
}