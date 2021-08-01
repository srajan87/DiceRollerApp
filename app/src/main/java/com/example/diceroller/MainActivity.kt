package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        rollButton.setOnClickListener { rollMultiDices(2) }

        // Find the image view in the layout for ALL dices and roll them
        rollMultiDices(2)
    }

    /**
     * Function to roll multiple dices
     */
    private fun rollMultiDices(numOfDices: Int) {

        // Find the image view in the layout for all dices and roll them
        for (i in (1..numOfDices)) {
            rollDice(findViewById(getImageViewId(i)))
        }
    }

    /**
     * Function to get Image View ID based on dice number
     */
    private fun getImageViewId(diceNum: Int): Int {
        return when (diceNum) {
            1 -> (R.id.imageView)
            else -> (R.id.imageView2)
        }
    }

    /**
     * Roll the Dice and update the screen with results*
     */
    private fun rollDice(diceImage: ImageView) {
        // Create Dice object with number of sides as 6
        val dice = Dice(6)

        // Roll the dice
        val diceRoll = dice.roll()

        // Determine which Drawable Resource ID based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct Drawable Resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
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