package com.example.sw_api.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.sw_api.screens.characters_screen_composables.CharacterList
import com.example.sw_api.viewmodels.CharacterViewModel
import com.example.sw_api.viewmodels.CharactersUiState


@Composable
fun CharactersScreen( viewModel: CharacterViewModel = hiltViewModel() ){

    val uiState = viewModel.charactersState.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()){

        when (val state = uiState.value) {
            is CharactersUiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            is CharactersUiState.Content -> {
                CharacterList(state.characters)
            }
            is CharactersUiState.Error -> {
                Text(
                    text = state.message,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}