package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
    }

    private fun rollDice() {
        val resultTextView = findViewById<TextView>(R.id.textView)
        val dice = Dice(6)
        val diceRoll = dice.roll()

        Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
        resultTextView.text = diceRoll.toString();
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}