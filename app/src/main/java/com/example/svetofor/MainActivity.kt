package com.example.svetofor

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

            private lateinit var circleRed: ImageView
            private lateinit var circleYellow: ImageView
            private lateinit var circleGreen: ImageView
            private lateinit var button: Button

            private var currentCircle = 0 // 0 - красный, 1 - желтый, 2 - зеленый

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                circleRed = findViewById(R.id.circle_1)
                circleYellow = findViewById(R.id.circle_2)
                circleGreen = findViewById(R.id.circle_3)
                button = findViewById(R.id.button)

                // Восстановление состояния при повороте экрана
                if (savedInstanceState != null) {
                    currentCircle = savedInstanceState.getInt("currentCircle")
                    updateCircles()
                }

                button.setOnClickListener {
                    // Смена цвета кругов
                    currentCircle = (currentCircle + 1) % 3
                    updateCircles()
                }
            }

            private fun updateCircles() {
                when (currentCircle) {
                    0 -> {
                        circleRed.setColorFilter(Color.RED)
                        circleYellow.setColorFilter(Color.GRAY)
                        circleGreen.setColorFilter(Color.GRAY)
                    }
                    1 -> {
                        circleRed.setColorFilter(Color.GRAY)
                        circleYellow.setColorFilter(Color.YELLOW)
                        circleGreen.setColorFilter(Color.GRAY)
                    }
                    2 -> {
                        circleRed.setColorFilter(Color.GRAY)
                        circleYellow.setColorFilter(Color.GRAY)
                        circleGreen.setColorFilter(Color.GREEN)
                    }
                }
            }

            override fun onSaveInstanceState(outState: Bundle) {
                super.onSaveInstanceState(outState)
                outState.putInt("currentCircle", currentCircle)
            }
        }