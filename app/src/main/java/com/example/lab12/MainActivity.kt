package com.example.lab12

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.os.Bundle
import com.example.lab12.MapScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                MapScreen()
            }
        }
    }