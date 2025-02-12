package com.example.dandypantry.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dandypantry.DandyPantryScreen
import com.example.dandypantry.ui.theme.DandyPantryTheme



@Composable
fun StartScreen(
    onNextButtonClicked: (DandyPantryScreen) -> Unit, //why int? next button is which of the menu options was picked
    onExitClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "What do you want to do?")
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            MenuButton(
                label = "Create new item",
                onClick = { onNextButtonClicked(DandyPantryScreen.Create) },
                modifier = Modifier.fillMaxWidth()
            )
            MenuButton(
                label = "View Inventory",
                onClick = { onNextButtonClicked(DandyPantryScreen.Inventory) },
                modifier = Modifier.fillMaxWidth()
            )
            MenuButton(
                label = "Exit",
                onClick = { onExitClicked() },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
@Composable
fun MenuButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text(text = label)
    }
}


@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    DandyPantryTheme {
        StartScreen(
            onNextButtonClicked = { },
            onExitClicked = {}
        )
    }
}