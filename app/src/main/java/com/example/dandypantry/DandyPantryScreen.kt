package com.example.dandypantry

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dandypantry.ui.theme.DandyPantryTheme


// this is the file for navigating between pages
// establish routes, etc

@Composable
fun DandyPantryScreen() {
    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize()
    ) {
        // when app starts

        // when app wants to go to the view inventory screen
        Button(
            onClick = { }
        ) {
            Text(text = "View Inventory")
        }

        // when app wants to go to the create item screen (C rud)
        Button(
            onClick = { }
        ) {
            Text(text = "Create")
        }

        // when app wants to view the item screen (c R ud)
        Button(
            onClick = { }
        ) {
            Text(text = "Read")
        }

        // when app wants to edit the item screen (cr U d)
        Button(
            onClick = { }
        ) {
            Text(text = "Update")
        }

        // when app wants to confirm delete the item screen (cru D)
        Button(
            onClick = { }
        ) {
            Text(text = "Delete")
        }

        // when app wants to exit
        Button(
            onClick = { }
        ) {
            Text(text = "Exit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DandyPantryScreenPreview() {
    DandyPantryTheme {
        DandyPantryScreen()
    }
}