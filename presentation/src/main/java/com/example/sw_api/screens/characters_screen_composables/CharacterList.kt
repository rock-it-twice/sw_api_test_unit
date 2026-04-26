package com.example.sw_api.screens.characters_screen_composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.domain.Character

@Composable
fun CharacterList(characters: List<Character>){
    LazyColumn() {
        items(characters){ character ->
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = character.name)
            }
        }
    }
}