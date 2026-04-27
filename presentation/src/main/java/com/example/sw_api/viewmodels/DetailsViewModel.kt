package com.example.sw_api.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.domain.entities.Character
import com.example.domain.GetCharacterDetailsUseCase
import com.example.sw_api.navigation.DetailsScreenRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val characterState = _state.asStateFlow()

    init {
        val route = savedStateHandle.toRoute<DetailsScreenRoute>()
        loadCharacter(route.url)
    }

    fun loadCharacter(url: String){
        viewModelScope.launch {
            _state.value = DetailsUiState.Loading
            getCharacterDetailsUseCase(url)
                .onSuccess {
                    character -> _state.value = DetailsUiState.Content(character)
                }
                .onFailure {
                    exception -> _state.value = DetailsUiState.Error(
                    exception.message ?: "something went wrong"
                    )
                }
        }
    }



}

sealed class DetailsUiState {
    data object Loading: DetailsUiState()
    data class Content(val character: Character): DetailsUiState()
    data class Error(val message: String): DetailsUiState()
}