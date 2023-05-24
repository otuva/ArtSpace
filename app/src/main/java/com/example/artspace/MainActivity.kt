package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp(imageArray = imageArray)
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(imageArray: Array<DisplayImage>, modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageAndText(displayImage = imageArray[currentIndex], modifier = Modifier.weight(1f))
        NavButtons(
            onPrevious = {
                if (currentIndex > 0) currentIndex--
            },
            onNext = {
                if (currentIndex < imageArray.size-1) currentIndex++
            }
        )
    }
}

@Composable
fun ImageAndText(displayImage: DisplayImage, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // image title
        Text(
            text = displayImage.title,
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)
        )

        // image in lifted box
        Box(
            modifier = Modifier
                .shadow(elevation = 16.dp) // add shadow effect
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 24.dp)
        ) {
            Image(
                painter = painterResource(id = displayImage.resource),
                contentDescription = displayImage.description,
                modifier = Modifier
                    .align(Alignment.Center)
                    .requiredSize(360.dp)
            )
        }

        // artist name and year
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = displayImage.artist,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = displayImage.year,
                fontStyle = FontStyle.Italic
            )
        }

    }
}

@Composable
fun NavButtons(onPrevious: () -> Unit, onNext: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = onPrevious, Modifier.width(160.dp)) {
            Text(text = stringResource(R.string.previous), fontSize = 16.sp)
        }

        Button(onClick = onNext, Modifier.width(160.dp)) {
            Text(text = stringResource(R.string.next), fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp(imageArray = imageArray)
    }
}