package com.stu71930.threescreens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class SecondScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val word = intent.getStringExtra("WORD") ?: ""
        setContent {
            Screen2(word, onGoBack = {
                startActivity(Intent(this, MainActivity::class.java))
            }, onGoToScreen3 = {
                val intent = Intent(this, ThirdScreen::class.java)
                intent.putExtra("WORD", word)
                startActivity(intent)
            })
        }
    }
}

@Composable
fun Screen2(word: String, onGoBack: () -> Unit, onGoToScreen3: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Word: ${word.uppercase()}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onGoBack) {
            Text("Go Back to Landing")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onGoToScreen3) {
            Text("Go to Screen 3")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen2Preview() {
    Screen2(word = "hello there!", onGoBack = {}, onGoToScreen3 = {})
}