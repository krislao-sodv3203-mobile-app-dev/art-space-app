package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun ArtworkCard(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.padding(16.dp),
        shape = RoundedCornerShape(4.dp),
        shadowElevation = 4.dp,
        border = BorderStroke(
            width = 2.dp,
            color = Color.Gray.copy(alpha = 0.3f)
        )
    ) {
        Box(modifier = Modifier.padding(32.dp)) {
            Image(
                painter = painterResource(R.drawable.artwork1),
                contentDescription = stringResource(R.string.artwork1_title),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio = 2f / 3f)
            )
        }
    }
}

@Composable
fun ArtworkCitation(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .background(Color(0xFFD4D1ED))
        .padding(20.dp)) {
        Text(
            text = stringResource(R.string.artwork1_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            buildAnnotatedString { 
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(stringResource(R.string.artwork1_artist))
                }
                append(" (${stringResource(R.string.artwork1_year)})")
            }
        )
    }

}

@Composable
fun DisplayController(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Button(
            modifier = Modifier.weight(1f),
            onClick = { }
        ) {
            Text(stringResource(R.string.previous))
        }
        Button(
            modifier = Modifier.weight(1f),
            onClick = { }
        ) {
            Text(stringResource(R.string.next))
        }
    }
}

@Composable
fun Artwork(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ArtworkCard(modifier = Modifier.fillMaxWidth())
        ArtworkCitation()
    }
}

@Composable
fun ArtworkSpaceApp(modifier: Modifier = Modifier) {
    // TODO: add state here to determine which artwork to display
    Column(modifier = modifier) {
        // TODO: pass modifier
        Artwork()
        DisplayController()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ArtworkCardPreview() {
//    ArtSpaceAppTheme {
//        ArtworkCard()
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun ArtworkCitationPreview() {
//    ArtSpaceAppTheme {
//        ArtworkCitation()
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun DisplayControllerPreview() {
//    ArtSpaceAppTheme {
//        DisplayController()
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun ArtworkSpaceAppPreview() {
//    ArtSpaceAppTheme {
//        ArtworkSpaceApp()
//    }
//}