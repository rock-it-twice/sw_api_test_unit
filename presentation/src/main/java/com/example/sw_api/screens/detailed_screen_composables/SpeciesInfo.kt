package com.example.sw_api.screens.detailed_screen_composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.data.R
import com.example.domain.entities.Species
import com.example.sw_api.screens.common_composables.Subtitle


@Composable
fun SpeciesInfo(species: List<Species>){
    Column {
        Subtitle(stringResource(com.example.sw_api.R.string.h_species))
        Spacer(modifier = Modifier.size(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(12.dp )
                )
                .border(
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline
                    ),
                    shape = RoundedCornerShape(12.dp)
                ),
            contentAlignment = if (species.isEmpty()) Alignment.Center else Alignment.CenterStart
        ){
            if (species.isEmpty()){
                Text(
                    text = stringResource(com.example.sw_api.R.string.no_spec_info),
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            } else{
                species.forEach {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = it.classification,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                    }
                }
            }
        }
    }
}