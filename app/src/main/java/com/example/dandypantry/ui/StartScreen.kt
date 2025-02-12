package com.example.dandypantry.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dandypantry.ui.theme.DandyPantryTheme

@Composable
fun StartScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "What do you want to do?")
            MenuButton(label = "Create new Item", onClick = { }, Modifier.weight(1f))
            MenuButton(label = "View Inventory", onClick = { }, Modifier.weight(1f))
            MenuButton(label = "Exit", onClick = { }, Modifier.weight(1f))
        }
    }
}
@Composable
fun MenuButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Button(
        onClick = onClick
    ) {
        Text(text = label)
    }
}
@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    DandyPantryTheme {
        StartScreen()
    }
}