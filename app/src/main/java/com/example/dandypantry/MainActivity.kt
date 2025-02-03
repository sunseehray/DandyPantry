package com.example.dandypantry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dandypantry.ui.theme.DandyPantryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DandyPantryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AddItemPage()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DandyPantryTheme {
        AddItemPage()
    }
}

@Composable
fun AddItemPage(modifier: Modifier = Modifier) {
    var nameInput by remember { mutableStateOf("") }
    var quantityInput by remember { mutableStateOf("0") }
    var costInput by remember { mutableStateOf("0") }
    var notesInput by remember { mutableStateOf("") }

    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title("Add Item")
        Spacer(modifier = Modifier.height(20.dp))

        AddItemLayout()

    }

}

@Composable
fun AddItemLayout() {
    var nameValue by remember { mutableStateOf("") }
    var qtyValue by remember { mutableStateOf("0") }

    TextField(
        value = nameValue,
        onValueChange = { nameValue = it},
        singleLine = true,
        label = { Text(stringResource(R.string.name_item_label)) },
    )
    Spacer(modifier = Modifier.height(20.dp))

    TextField(
        value = qtyValue,
        onValueChange = { qtyValue = it },
        singleLine = true,
        label = { Text(stringResource(R.string.quantity_item_label)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun PreviewItemCard() {

}

@Composable
fun Title(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

