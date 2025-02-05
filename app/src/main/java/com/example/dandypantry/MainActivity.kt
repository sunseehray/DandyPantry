package com.example.dandypantry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
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

@Composable
fun AddItemPage() {
    var nameInput by remember { mutableStateOf("") }
    var quantityInput by remember { mutableStateOf("") }
    var costInput by remember { mutableStateOf("") }
    var notesInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // heading
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.add_new_item_title),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))

        // item name input field
        EditTextField(
            label = R.string.name_item_label,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            value = nameInput,
            onValueChange = { nameInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        // item quantity row
        Row(
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // MINUS button for quantity field
            Button(
                onClick = {
                    val currentQuantity = quantityInput.toIntOrNull() ?: 0
                    if (currentQuantity > 0) {
                        quantityInput = (currentQuantity - 1).toString()
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "-")
            }

            Spacer(modifier = Modifier.width(8.dp))

            EditTextField(
                label = R.string.quantity_item_label,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                value = quantityInput,
                onValueChange = { quantityInput = it },
                modifier = Modifier.weight(2f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    val currentQuantity = quantityInput.toIntOrNull() ?: 0
                    quantityInput = (currentQuantity + 1).toString()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "+")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        EditTextField(
            label = R.string.cost_item_label,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = costInput,
            onValueChange = { costInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        EditTextField(
            label = R.string.notes_item_label,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            value = notesInput,
            onValueChange = { notesInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        Button (
            onClick = { },
            modifier = Modifier
                .padding(top = 32.dp)
        ) {
            Text(text = "Add", fontSize = 24.sp)
        }
    }
}

@Composable
fun EditTextField(
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label ={ Text(stringResource(label)) },
        keyboardOptions = keyboardOptions,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DandyPantryTheme {
        AddItemPage()
    }
}


