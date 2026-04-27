package com.example.sw_api.screens.characters_screen_composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.entities.Character

@Composable
fun CharacterList(characters: List<Character>, onClick: (String) -> Unit){

    var searchQuery by remember { mutableStateOf("") }

    val filteredCharacters by remember(searchQuery) {
        derivedStateOf {
            if (searchQuery.isBlank()){
                characters
            } else {
                characters.filter {
                    it.name.contains(searchQuery, ignoreCase = true)
                }
            }
        }
    }

    LazyColumn() {
        item { SearchBar(searchQuery, onValueChange = { searchQuery = it }) }
        item { Spacer(modifier = Modifier.size(20.dp)) }
        items( filteredCharacters ){ character ->
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CharacterCard(character = character, onClick = onClick)
            }
            Spacer(modifier = Modifier.size(10.dp))
        }
    }
}