package com.example.dandypantry.ui.model

data class InventoryItem(
    val sku: String,
    val name: String,
    var price: Double,
    var quantity: Int = 0,
    var notes: String = "",
)