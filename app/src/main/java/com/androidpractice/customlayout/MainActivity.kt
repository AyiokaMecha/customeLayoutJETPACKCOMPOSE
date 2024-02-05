package com.androidpractice.customlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidpractice.customlayout.ui.compoenents.CascadeLayout
import com.androidpractice.customlayout.ui.compoenents.cascadeLayout
import com.androidpractice.customlayout.ui.theme.CustomLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    //using the customLayout
    Box {
        CascadeLayout(spacing = 20) {
            Box(
                modifier =
                Modifier.size(60.dp).background(Color.Blue).cascadeLayout(30,30)
            )
            Box(
                modifier = Modifier.size(
                    80.dp,
                    40.dp
                ).background(Color.Red)
            )
            Box(
                modifier = Modifier.size(
                    90.dp,
                    100.dp
                ).background(Color.Cyan)
            )
            Box(
                modifier =
                Modifier.size(50.dp).background(Color.Magenta)
            )
            Box(
                modifier =
                Modifier.size(70.dp).background(Color.Green)
            )
        }}

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CustomLayoutTheme {
        MainScreen()
    }
}