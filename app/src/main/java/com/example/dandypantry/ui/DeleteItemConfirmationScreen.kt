package com.example.dandypantry.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// Screen for confirming item to delete

// Button CONFIRM - redirect to InventoryScreen, item should no longer be found
// Button CANCEL - redirect to ItemViewScreen

@Composable
fun DeleteItemConfirmationScreen() {
    Text(text = "Confirm Delete Item")
}