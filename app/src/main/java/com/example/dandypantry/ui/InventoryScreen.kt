package com.example.dandypantry.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dandypantry.ui.theme.DandyPantryTheme

// Screen for viewing a list of the inventory

// Each item on the list is a button that redirects to the item's view page - ItemViewScreen

@Composable
fun InventoryScreen() {
    Column() {
        Text(text = "Inventory Screen")
        Column() {
            ItemCard("Item 1")
            ItemCard("Item 2")
            ItemCard("Item 3")
        }
        Column() {
            Button(
                onClick = {},
            ) {
                Text(text = "BACK")
            }
        }
    }

}

// Row of item with name, quantity, price, and view button
@Composable
fun ItemCard(
    text: String,
) {
    Text(text = text)
}

@Preview(showBackground = true)
@Composable
fun InventoryScreenPreview() {
    DandyPantryTheme {
        InventoryScreen()
    }
}