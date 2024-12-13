package fyi.hayden.basiclauncher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fyi.hayden.basiclauncher.ui.theme.BasicLauncherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LauncherView()
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Hello world"
        )
    }
}

@Composable
fun AppsListScreen(modifier: Modifier = Modifier) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Apps"
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LauncherView(modifier: Modifier = Modifier) {
    BasicLauncherTheme {
        val pagerState = rememberPagerState(pageCount = { 2 })
        HorizontalPager(state = pagerState, contentPadding = PaddingValues(end = 32.dp)) { page ->
            when (page) {
                0 -> HomeScreen()
                1 -> AppsListScreen()
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_6A, showSystemUi = true)
@Composable
fun LauncherViewPreview() {
    LauncherView()
}