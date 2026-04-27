package com.example.sw_api.viewmodels

import android.os.Message
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Character
import com.example.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _charactersState =
        MutableStateFlow<CharactersUiState>(CharactersUiState.Loading)
    val charactersState = _charactersState.asStateFlow()


    init { loadCharacters() }

    fun loadCharacters() {
        viewModelScope.launch {
            _charactersState.value = CharactersUiState.Loading

            getCharactersUseCase()
                .onSuccess { list ->
                    Log.d("MY_TAG", "Успех ViewModel получила ${list.size} элементов")
                    _charactersState.value = CharactersUiState.Content(list)
                }
                .onFailure { exception ->
                    Log.e("MY_TAG", "Ошибка в цепочке!", exception)
                   _charactersState.value = CharactersUiState.Error(
                       exception.message ?: "something went wrong"
                   )
                }
        }
    }

}

sealed class CharactersUiState {
    data object Loading: CharactersUiState()
    data class Content(val characters: List<Character>): CharactersUiState()
    data class Error(val message: String): CharactersUiState()
}