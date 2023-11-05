package com.prima.amphibians.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.prima.amphibians.AmphibiansApplication
import com.prima.amphibians.data.AmphibiansRepository
import com.prima.amphibians.ui.uistate.AmphibiansUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class AmphibiansViewModel(
    private val amphibiansRepository: AmphibiansRepository
): ViewModel() {

    /** Create UI State for store status or change state */
    var uiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibiansList()
    }

    fun getAmphibiansList() {
        viewModelScope.launch {
            uiState = AmphibiansUiState.Loading

            uiState = try {
                AmphibiansUiState.Success(amphibiansRepository.getListAmphibians())
            } catch (e: IOException) {
                Log.d("IOEXception", "getAmphibiansList: error with e: ${e.message}")
                AmphibiansUiState.Error
            } catch (e: HttpException) {
                Log.d("HttpException", "getAmphibiansList: error with e: ${e.message}")
                AmphibiansUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibiansViewModel(
                    amphibiansRepository = amphibiansRepository
                )
            }
        }
    }
}