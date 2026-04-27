package com.example.sw_api.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.sw_api.screens.characters_screen_composables.TryAgainButton
import com.example.sw_api.screens.detailed_screen_composables.DetailedCard
import com.example.sw_api.viewmodels.DetailsViewModel
import com.example.sw_api.viewmodels.DetailsUiState

@Composable
fun DetailsScreen(
    url: String,
    viewModel: DetailsViewModel = hiltViewModel(),
    onGoBackClick: ()-> Unit
){
    val uiState = viewModel.characterState.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize().padding(top = 20.dp)) {
        when (val state = uiState.value){
            is DetailsUiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()){
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            is DetailsUiState.Content -> {
                DetailedCard(state.character) { onGoBackClick() }
            }
            is DetailsUiState.Error -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = state.message,
                        color = Color.Red
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    TryAgainButton { viewModel.loadCharacter(url) }
                }
            }
        }
    }
}