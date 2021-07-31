package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the Dice and update the screen with results*
     */
    private fun rollDice() {
        // Create Dice object with number of sides as 6
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with Dice Roll Result
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
    }
}

/**
 * Dice class has a property side and method roll which returns a random number
 */
class Dice(private val numSides: Int) {

    // roll function which returns a random side number
    fun roll(): Int {
        return ((1..numSides).random())
    }
}