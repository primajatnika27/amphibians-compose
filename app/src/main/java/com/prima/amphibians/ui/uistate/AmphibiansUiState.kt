package com.prima.amphibians.ui.uistate

import com.prima.amphibians.model.Amphibians

interface AmphibiansUiState {
    data class Success(val data: List<Amphibians>): AmphibiansUiState
    object Error: AmphibiansUiState
    object Loading: AmphibiansUiState
}