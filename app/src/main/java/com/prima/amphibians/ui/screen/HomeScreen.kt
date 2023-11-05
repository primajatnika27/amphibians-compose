package com.prima.amphibians.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.prima.amphibians.model.Amphibians
import com.prima.amphibians.ui.uistate.AmphibiansUiState

@Composable
fun HomeScreen(
    uiState: AmphibiansUiState,
    retryAction: () -> Unit
) {
    when(uiState) {
        is AmphibiansUiState.Success -> ResultList(amphibiansList = uiState.data)
        is AmphibiansUiState.Error -> Box(
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = retryAction) {
                Text(text = "retry")
            }
        }
        is AmphibiansUiState.Loading -> Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(200.dp)
        ) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun ResultList(
    amphibiansList: List<Amphibians>
) {
    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier.padding(start = 15.dp, end = 15.dp),
        columns = GridCells.Fixed(1), content = {
        items(amphibiansList) {
            CardLayout(amphibians = it)
        }
    })
}

@Composable
fun CardLayout(
    amphibians: Amphibians,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
    ) {
        Column {
            Text(
                text = amphibians.name,
                modifier = modifier.padding(top = 20.dp, start = 10.dp, end = 10.dp, bottom = 20.dp),
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(amphibians.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = modifier.height(200.dp))
            Text(
                text = amphibians.description,
                modifier = modifier.padding(top = 20.dp, start = 10.dp, end = 10.dp, bottom = 10.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview
@Composable
fun CardLayoutPreview() {
    CardLayout(
        Amphibians(
            name = "Great Basin Speadfoot",
            type = "",
            description = "This toad is typically found in South America. Specifically on Mount Roraima " +
                    "at the boarders of Venezuala, Brazil, and Guyana, hence the name. The Roraiam Bush " +
                    "Toad is typically black with yellow spots or marbling along the throat and belly.",
            imgSrc = ""
        )
    )
}