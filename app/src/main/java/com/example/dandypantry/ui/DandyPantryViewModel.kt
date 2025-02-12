package com.example.dandypantry.ui

import androidx.lifecycle.ViewModel
import com.example.dandypantry.ui.data.DandyPantryUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DandyPantryViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DandyPantryUiState())
    val uiState: StateFlow<DandyPantryUiState> = _uiState.asStateFlow()

    // set sku that will undergo CRUD operation
    fun setSku(sku: String) {
        _uiState.update { currentState ->
            currentState.copy(
                sku = sku
            )
        }
    }

    // reset sku
    fun resetSku() {
        _uiState.value = DandyPantryUiState(sku = "")
    }
}