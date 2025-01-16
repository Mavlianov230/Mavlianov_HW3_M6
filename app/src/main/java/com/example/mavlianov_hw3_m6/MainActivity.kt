package com.example.mavlianov_hw3_m6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mavlianov_hw3_m6.ui.theme.Mavlianov_HW3_M6Theme
import com.example.mavlianov_hw3_m6.ui.theme.tools.Main.MainNavScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mavlianov_HW3_M6Theme {
              MainNavScreen()
            }
        }
    }
}
