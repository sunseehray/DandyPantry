package com.example.dandypantry.ui.data

import com.example.dandypantry.ui.model.InventoryItem

data class DandyPantryUiState(
    val inventoryList: List<InventoryItem> = listOf(), // This is actually a list of items
    val sku: String = "",
)
