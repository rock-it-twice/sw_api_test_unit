package com.example.sw_api.screens.characters_screen_composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.entities.Character

@Composable
fun CharacterCard( character: Character, onClick: (String) -> Unit ){

    val name = character.name
    val basicInfo =
        "Height: ${character.height}, " +
        "Mass: ${character.mass}, " +
        "Hair: ${character.hairColor}, " +
        "Eyes: ${character.eyeColor}"

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = true, onClick = { onClick(character.url) })
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(12)
            )
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline
                ),
                shape = RoundedCornerShape(12)
            ),
        contentAlignment = Alignment.Center
    )
    {
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 16.dp)
                .fillMaxSize()
        ) {
            Row() {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Row() {
                Text(
                    text = basicInfo,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }
    }
}