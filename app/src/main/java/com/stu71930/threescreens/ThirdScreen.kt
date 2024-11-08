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


class ThirdScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val word = intent.getStringExtra("WORD") ?: ""
        setContent {
            Screen3(word, onGoBack = {
                startActivity(Intent(this, MainActivity::class.java))
            }, onGoToScreen2 = {
                val intent = Intent(this, SecondScreen::class.java)
                intent.putExtra("WORD", word)
                startActivity(intent)
            })
        }
    }
}

@Composable
fun Screen3(word: String, onGoBack: () -> Unit, onGoToScreen2: () -> Unit) {
    val vowelCount = countVowels(word)
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Number of vowels in '$word': $vowelCount")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onGoBack) {
            Text("Go Back to Landing")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onGoToScreen2) {
            Text("Go to Screen 2")
        }
    }
}

fun countVowels(word: String): Int {
    return word.lowercase().count { it in "aeiou" }
}

@Preview(showBackground = true)
@Composable
fun Screen3Preview() {
    Screen3(word = "compose", onGoBack = {}, onGoToScreen2 = {})
}