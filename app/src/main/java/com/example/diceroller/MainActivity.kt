package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* roll button event listener
        * - Toast (popup text)
        * - set button to change textview */
        val rollButton = findViewById<Button>(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    private fun rollDice() {
        val diceImage = findViewById<ImageView>(R.id.imageView)
        val dice = Dice(6)
        val diceRoll = dice.roll()

        Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource) // Update the ImageView with the correct drawable resource ID
        diceImage.contentDescription = diceRoll.toString() // Update the content description
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}