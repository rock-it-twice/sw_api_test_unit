package com.example.sw_api.screens.detailed_screen_composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.domain.entities.Character
import com.example.sw_api.R
import com.example.sw_api.screens.common_composables.Title

@Composable
fun DetailedCard(character: Character, onGoBackClick: () -> Unit) {

    val name = character.name
    val basicInfo = listOf<Pair<String, String>>(
        "Birth Year" to character.birthYear,
        "Height" to character.height,
        "Mass" to character.mass,
        "Gender" to character.gender
    )
    val species = when {
        character.species.isEmpty() -> { stringResource(R.string.no_spec_info) }
        else -> { character.species }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Title(name) { onGoBackClick() }
            Spacer(modifier = Modifier.size(20.dp))
        }
        item {
            BasicInfo(basicInfo)
            Spacer(modifier = Modifier.size(20.dp))
        }
        item {
            SpeciesInfo(character.species)
            Spacer(modifier = Modifier.size(20.dp))
        }
        item {
            FilmsInfo(character.films)
            Spacer(modifier = Modifier.size(20.dp))
        }



    }
}