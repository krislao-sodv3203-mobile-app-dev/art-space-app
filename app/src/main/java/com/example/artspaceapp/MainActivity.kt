package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.model.Artwork
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtworkSpaceApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ArtworkCard(
    @DrawableRes image: Int,
    @StringRes title: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp),
        shadowElevation = 8.dp,
        border = BorderStroke(
            width = 2.dp,
            color = Color.Gray.copy(alpha = 0.3f)
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(36.dp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(title),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 4f)
            )
        }
    }
}

@Composable
fun ArtworkCitation(
    @StringRes title: Int,
    @StringRes artist: Int,
    @StringRes year: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .background(Color(0xFFECEBF4))
                .padding(20.dp)
        ) {
            Text(
                text = stringResource(title),
                fontSize = 24.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Left
            )
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(stringResource(artist))
                    }
                    append(" (${stringResource(year)})")
                }
            )
        }
    }

}

@Composable
fun DisplayController(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Button(
            modifier = Modifier.widthIn(120.dp),
            onClick = { /* TODO */ }
        ) {
            Text(stringResource(R.string.previous))
        }
        Button(
            modifier = Modifier.widthIn(120.dp),
            onClick = { /* TODO */ }
        ) {
            Text(stringResource(R.string.next))
        }
    }
}

@Composable
fun Artwork(
    artwork: Artwork,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        ArtworkCard(
            image = artwork.imageResourceId,
            title = artwork.titleResourceId,
            modifier = Modifier
                .widthIn(max = 450.dp)
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        ArtworkCitation(
            title = artwork.titleResourceId,
            artist = artwork.artistResourceId,
            year = artwork.yearResourceId,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun ArtworkSpaceApp(modifier: Modifier = Modifier) {
    val artwork = Artwork(
        imageResourceId = R.drawable.artwork3,
        titleResourceId = R.string.artwork1_title,
        artistResourceId = R.string.artwork1_artist,
        yearResourceId = R.string.artwork1_year
    )
    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState)
        ) {
            Artwork(
                artwork = artwork,
                modifier = Modifier
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        DisplayController(
            modifier = Modifier.padding(
                vertical = 8.dp,
                horizontal = 24.dp
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkSpaceAppPreview() {
    ArtSpaceAppTheme {
        ArtworkSpaceApp(modifier = Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkCardPreview() {
    ArtSpaceAppTheme {
        ArtworkCard(
            image = R.drawable.artwork2,
            title = R.string.artwork1_title,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkCitationPreview() {
    ArtSpaceAppTheme {
        ArtworkCitation(
            title = R.string.artwork1_title,
            artist = R.string.artwork1_artist,
            year = R.string.artwork1_year,
            modifier = Modifier
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DisplayControllerPreview() {
    ArtSpaceAppTheme {
        DisplayController(modifier = Modifier)
    }
}
